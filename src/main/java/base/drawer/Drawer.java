package base.drawer;

import base.ScreenLoader.ScreenLoader;

import java.io.IOException;

public abstract class Drawer<T> {
    private final T model;

    public Drawer(T model){
        this.model = model;
    }

    public T getModel(){
        return model;
    }

    public void draw(ScreenLoader screen) throws IOException{
        screen.clear();
        drawElements(screen);
        screen.refresh();
    }
    protected abstract void drawElements(ScreenLoader screen);
}
