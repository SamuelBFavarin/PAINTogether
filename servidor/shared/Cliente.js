'use strict';

module.exports = class Cliente {
    constructor(socket) {
        this._socket = socket;
    }

    getSocketID() {
        return this._socket.id;
    }
}