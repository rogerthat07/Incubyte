package com.incubyte.spring.exception;

public class WordDoesNotExist extends Exception{

    public WordDoesNotExist(){
        super();
    }

    public WordDoesNotExist(String message){
        super(message);
    }

    public WordDoesNotExist(Exception e){
        super(e);
    }

}
