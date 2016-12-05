var io = require('socket.io')(80);

io.on('connection', function (socket) {

    socket.on('disconnect', function () {

    });
});