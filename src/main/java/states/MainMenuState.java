package states;

import ScreenLoader.ScreenLoader;
import base.MainMenu;
import controller.Controller;
import controller.menu.MenuController;
import drawer.Drawer;
import drawer.menu.MainMenuDrawer;
import menu.Menu;

import java.io.IOException;

public class MainMenuState extends State{
    Menu menu;

    public MainMenuState(Menu menu){
        super("MainMenu");
        this.menu= menu;
    }

    public Controller getController(){
        return new MenuController();
    }
    public Drawer getDrawer() {
        return new MainMenuDrawer(menu);
    }
}
