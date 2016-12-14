/**
 * Created by Lucas Baragatti on 12/12/2016.
 */

var io = require('socket.io')(90);

var newRoomId = 1;
var rooms = [];
var users = [];

function createUser(socketId) {
    users[socketId] = {
        roomId: 0
    };
}

function deleteUser(socketId) {
    if (users[socketId].roomId != 0) {
        var roomId = users[socketId];
        rooms["#" + roomId].users.splice(rooms["#" + roomId].users.indexOf(socketId, 1));
    }
    delete users[socketId];
}

function createRoom(socketId) {
    var roomId = newRoomId++;
    rooms["#" + roomId] = {
        canJoin: true,
        canDraw: false,
        users: [].push(socketId)
    }
}

function joinRoom(socketId, roomId) {
    if (typeof rooms["#" + roomId] !== 'undefined') {
        if (users[socketId].roomId == 0) {
            users[socketId].roomId = roomId;
            rooms["#" + roomId].users.push(socketId);
        }
    }
}

io.on('connection', function (socket) {
    createUser(socket.id);

    socket.on('disconnect', function () {

    });

});