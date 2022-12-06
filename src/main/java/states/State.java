package states;

import ScreenLoader.ScreenLoader;
import base.Application;
import base.Position;
import com.googlecode.lanterna.screen.Screen;
import controller.Controller;
import drawer.Drawer;
import drawer.menu.MainMenuDrawer;
import menu.Menu;

import java.io.IOException;

public abstract class State<T> {
    protected final String state;
    protected final T context;
    protected final Controller controller;
    protected final Drawer drawer;
    public State(String state,T context){
        this.state=state;
        this.context=context;
        this.controller = getController();
        this.drawer = getDrawer();
    }

    public String getState() {
        return state;
    }
    public abstract Controller getController();
    public abstract Drawer getDrawer();

    public void step(Application application, ScreenLoader screen, long time) {
        Position mousePressed = screen.getMousePressed();
        controller.step(application, mousePressed, time);
        try {
            drawer.draw(screen);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
