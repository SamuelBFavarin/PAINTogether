'use strict';
/**
 * Created by Lucas Baragatti on 12/12/2016.
 */

var io = require('socket.io')(90);

var newRoomId = 1000;
var rooms = [];
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

function createRoom(socket) {
    var socketId = socket.id;
    var roomId = newRoomId++;

    console.log(socketId + " Creating room " + roomId);

    var roomUsers = [];
    roomUsers.push(socketId);

    rooms["#" + roomId] = {
        canJoin: true,
        canDraw: false,
        users: roomUsers
    }
}

function joinRoom(socket, roomId) {
    var socketId = socket.id;

    if (typeof rooms["#" + roomId] !== 'undefined') {
        if (users[socketId].roomId == 0) {
            console.log(socketId + " Joining room " + roomId);

            users[socketId].roomId = roomId;
            rooms["#" + roomId].users.push(socketId);

            var roomUsers = rooms["#" + roomId].users;
            for (let i = 0; roomUsers.length; i++) {
                if (roomUsers[i].socketId != socketId) {
                    io.to(roomUsers[i].socketId).emit("cl_user_joined", data);
                }
            }
        }
    }
    else {
        io.to(socketId).emit("cl_error", "A sala escolhida não existe!");
    }
}

function deleteRoom(roomId) {
    if (typeof rooms["#" + roomId] !== 'undefined') {
        console.log("Deleting room " + roomId);
        delete rooms["#" + roomId];
    }
}

function leaveRoom(socket) {
    var socketId = socket.id;
    var roomId = users[socketId].roomId;

    if (roomId != 0 && typeof rooms["#" + roomId] !== 'undefined') {
        rooms["#" + roomId].users.splice(rooms["#" + roomId].users.indexOf(socketId), 1);

        if (rooms["#" + roomId].users.length == 0)
            deleteRoom(roomId);
    }
}

function sendData(socket, data) {
    var socketId = socket.id;
    var roomId = users[socketId].roomId;

    if (roomId != 0 && typeof rooms["#" + roomId] !== 'undefined') {
        var roomUsers = rooms["#" + roomId].users;
        for (let i = 0; roomUsers.length; i++) {
            if (roomUsers[i].socketId != socketId) {
                io.to(roomUsers[i].socketId).emit("cl_receive_data", data);
            }
        }
    }
}

io.on('connection', function (socket) {
    createUser(socket);

    socket.on('sv_create_room', function () {
        createRoom(socket);
    });

    socket.on('sv_join_room', function (roomId) {
        joinRoom(socket, roomId);
    });

    socket.on('sv_send_data', function (data) {
        sendData(socket, data);
        console.log(data);
    });

    socket.on('disconnect', function () {
        deleteUser(socket);
    });

});