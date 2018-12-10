package com.eventos.apirest.observer;

public interface Sujeito {

    public interface Subject {


        public void cadastrar(Observador obj);
        public void descadastrar(Observador obj);
        public void notificar();


    }
}
