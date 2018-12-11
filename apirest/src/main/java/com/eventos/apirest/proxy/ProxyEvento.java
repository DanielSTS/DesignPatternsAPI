package com.eventos.apirest.proxy;

import com.eventos.apirest.data.EventoDao;

public class ProxyEvento extends EventoDao {


    public void removerEvento(int e,int u){

        if(temPermissao(e,u)) {
            this.remover(e);
        }
    }

}
