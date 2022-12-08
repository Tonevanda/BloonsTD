package controller;

import base.Application;
import base.Position;


public abstract class Controller<T> {
    private final T model;
    public Controller(T model){
        this.model = model;
    }

    public T getModel(){
        return model;
    }

    public abstract void step(Application application, Position mousePressed, long time);
}
