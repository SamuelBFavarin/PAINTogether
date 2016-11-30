'use strict';

//Config
var porta = 90;

//Classes
var Cliente = require("./shared/Cliente");
var Sala = require("./shared/Sala");

//Inicio
var io = require('socket.io')(porta);

var clientes = [];

io.on('connection', function (socket) {
    clientes[socket] = new Cliente(socket);

    socket.on('disconnect', function () {
        if (typeof clientes[socket] !== 'undefined') {
            delete clientes[socket];
        }
    });
});