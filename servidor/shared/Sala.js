'use strict';

module.exports = class Sala {
    constructor() {
        this._codigo = null;
        this._clientes = [];
    }

    setCodigo(codigo) {
        this._codigo = codigo;
    }

    getCodigo() {
        return this._codigo;
    }

    addCliente(cliente){
        this._clientes.push(cliente);
    }

    removeCliente(cliente){
        for(var i=0; i < this._clientes.length; i++){
            if(this._clientes[i].getSocketID() == cliente.getSocketID()){
                delete this._clientes[i];
            }
        }
    }
}