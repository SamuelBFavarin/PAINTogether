var io = require('socket.io')(80);


var rooms = {};
var users = [];

io.on('connection', function (socket) {

    var myRoom = -1;
    users.push(socket);

    socket.on('disconnect', function () {
        /// como remover um elemento especifico da lista javascript
        rooms[room].
    });

    socket.on('joinRoom', function(room){
        if ( rooms[room] == undefined ){
            rooms[room] = [];
        }
        if ( myRoom !== -1 ){
            /// como remover um elemento especifico da lista javascript
            rooms[room].
        }
        rooms[room].push(socket);
        myRoom = room;
    });

    socket.on('draw', function(size,type,color,x,y){
        if ( room === -1 ) return;
        var actualRoom = rooms[myRoom];
        for (var i = 0; i < actualRoom.length; i++){
            actualRoom[i].emit(size,type,color,x,y);
        }
    });

});