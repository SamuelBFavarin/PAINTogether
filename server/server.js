/**
 * Created by Lucas Baragatti on 12/12/2016.
 */

var io = require('socket.io')(90);

var newRoomId = 1000;
var rooms = [];
var users = [];

function createUser(socketId) {
    users[socketId] = {
        roomId: 0,
        socketId: socketId
    };
}

function deleteUser(socket) {
    var socketId = socket.id;

    leaveRoom(socketId);

    delete users[socketId];
}

function createRoom(socket) {
    var socketId = socket.id;
    var roomId = newRoomId++;

    rooms["#" + roomId] = {
        canJoin: true,
        canDraw: false,
        users: [].push(socketId)
    }
}

function joinRoom(socket, roomId) {
    var socketId = socket.id;

    if (typeof rooms["#" + roomId] !== 'undefined') {
        if (users[socketId].roomId == 0) {
            users[socketId].roomId = roomId;
            rooms["#" + roomId].users.push(socketId);
        }
    }
}

function deleteRoom(roomId) {
    if (typeof rooms["#" + roomId] !== 'undefined') {
        delete rooms["#" + roomId];
    }
}

function leaveRoom(socket) {
    var socketId = socket.id;
    var roomId = users[socketId].roomId;

    if (roomId != 0 && typeof rooms["#" + roomId] !== 'undefined') {
        rooms["#" + roomId].users.splice(rooms["#" + roomId].users.indexOf(socketId, 1));

        if (rooms["#" + roomId].users.length == 0)
            deleteRoom(roomId);
    }
}

function sendData(socket, data) {
    var socketId = socket.id;
    var roomId = users[socketId].roomId;

    if (roomId != 0 && typeof rooms["#" + roomId] !== 'undefined') {
        var roomUsers = rooms["#" + roomId].users;
        for (var i = 0; roomUsers.length; i++) {
            if (roomUsers[i].socketId != socketId) {
                io.to(roomUsers[i].socketId).emit("receive data", data);
            }
        }
    }
}

io.on('connection', function (socket) {
    createUser(socket);

    socket.on('create room', function () {
        createRoom(socket);
    });

    socket.on('join room', function (roomId) {
        joinRoom(socket, roomId);
    });

    socket.on('send data', function (data) {
        sendData(socket, data);
    });

    socket.on('disconnect', function () {
        deleteUser(socket);
    });

});