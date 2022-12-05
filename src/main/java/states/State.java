package states;

import com.googlecode.lanterna.screen.Screen;
import drawer.Drawer;
import drawer.menu.MainMenuDrawer;
import menu.Menu;

public abstract class State<T> {
    private final T model;
    private final Drawer<T> drawer;

    public State(T model){
        this.model=model;
        this.drawer = getDrawer();
    }
    protected abstract Drawer<T> getDrawer();
    public T getModel() {
        return model;
    }

    //public Screen getScreen() {return screen;}

    //public abstract void drawImage();



}
