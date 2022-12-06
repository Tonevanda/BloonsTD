package states;

import ScreenLoader.ScreenLoader;
//import base.Game;
import base.MainMenu;
import base.Play;
import controller.Controller;
import controller.game.GameController;
import controller.menu.MenuController;
import drawer.Drawer;
import drawer.menu.GameDrawer;
import drawer.menu.MainMenuDrawer;

import java.io.IOException;

//é o play

public class GameState extends State<Play>{

    //Play play;

    public GameState(Play play){
        super("Game";play);
        //this.play=play;
    }


    public Controller getController(){
        return new GameController();
    }
    public Drawer getDrawer() {
        return new GameDrawer(play);
    }
}

