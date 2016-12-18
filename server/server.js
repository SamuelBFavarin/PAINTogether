'use strict';
/**
 * Created by Lucas Baragatti on 12/12/2016.
 */

var io = require('socket.io')(9090);

var newRoomId = 1000;
var rooms = [];
var roomsDraw = [];
var users = [];

function createUser(socket) {
    let socketId = socket.id;

    users[socketId] = {
        roomId: 0,
        socketId: socketId
    };
}

function deleteUser(socket) {
    let socketId = socket.id;

    leaveRoom(socket);

    delete users[socketId];
}

function createRoom(socket, fn) {
    var socketId = socket.id;
    var roomId = newRoomId++;

    console.log(socketId + " Creating room " + roomId);

    users[socketId].roomId = roomId;
    rooms["#" + roomId] = {
        users: [socketId]
    };
    roomsDraw["#" + roomId] = "";
    fn("1", roomId);
}

function joinRoom(socket, roomId, fn) {
    var socketId = socket.id;

    if (typeof rooms["#" + roomId] !== 'undefined') {
        if (users[socketId].roomId == 0) {
            console.log(socketId + " Joining room " + roomId);

            for (let i = 0; i < rooms["#" + roomId].users.length; i++) {
                let userSocketId = rooms["#" + roomId].users[i];
                if (userSocketId != socketId) {
                    socket.broadcast.to(userSocketId).emit("cl_user_count", rooms["#" + roomId].users.length);
                }
            }

            users[socketId].roomId = roomId;
            rooms["#" + roomId].users.push(socketId);


            if (roomsDraw["#" + roomId].length > 0)
                fn("1", "[" + roomsDraw["#" + roomId] + "]");
            else
                fn("1", "[]");
        }
    }
    else {
        fn("0", "A sala escolhida não existe!");
    }
}

function deleteRoom(roomId) {
    if (typeof rooms["#" + roomId] !== 'undefined') {
        console.log("Deleting room " + roomId);
        delete roomsDraw["#" + roomId];
        delete rooms["#" + roomId];
    }
}

function leaveRoom(socket) {
    var socketId = socket.id;
    var roomId = users[socketId].roomId;

    if (roomId != 0 && typeof rooms["#" + roomId] !== 'undefined') {
        rooms["#" + roomId].users.splice(rooms["#" + roomId].users.indexOf(socketId), 1);

        for (let i = 0; i < rooms["#" + roomId].users.length; i++) {
            let userSocketId = rooms["#" + roomId].users[i];
            if (userSocketId != socketId) {
                socket.broadcast.to(userSocketId).emit("cl_user_count", rooms["#" + roomId].users.length);
            }
        }

        if (rooms["#" + roomId].users.length == 0)
            deleteRoom(roomId);
    }
}

function clearRoom(socket) {
    var socketId = socket.id;
    var roomId = users[socketId].roomId;

    if (roomId != 0 && typeof rooms["#" + roomId] !== 'undefined') {
        for (let i = 0; i < rooms["#" + roomId].users.length; i++) {
            let userSocketId = rooms["#" + roomId].users[i];
            if (userSocketId != socketId) {
                socket.broadcast.to(userSocketId).emit("cl_clear_room");
            }
        }
    }
    roomsDraw["#" + roomId] = "";
}

function sendData(socket, data) {
    var socketId = socket.id;
    var roomId = users[socketId].roomId;

    if (roomId != 0 && typeof rooms["#" + roomId] !== 'undefined') {
        for (let i = 0; i < rooms["#" + roomId].users.length; i++) {
            let userSocketId = rooms["#" + roomId].users[i];
            if (userSocketId != socketId) {
                socket.broadcast.to(userSocketId).emit("cl_receive_data", data);
            }
        }

        if (roomsDraw["#" + roomId].length > 0)
            roomsDraw["#" + roomId] += ",";

        roomsDraw["#" + roomId] += data.substr(1, data.length - 2);
    }
}

io.on('connection', function (socket) {
    createUser(socket);

    socket.on('sv_create_room', function (ignore, fn) {
        createRoom(socket, fn);
    });

    socket.on('sv_join_room', function (roomId, fn) {
        joinRoom(socket, roomId, fn);
    });

    socket.on('sv_clear_room', function () {
        clearRoom(socket);
    });

    socket.on('sv_send_data', function (data) {
        sendData(socket, data);
    });

    socket.on('disconnect', function () {
        deleteUser(socket);
    });

});