package states;

import base.Play;
import controller.Controller;
import controller.game.PlayController;
import drawer.Drawer;
import drawer.game.GameDrawer;

//é o play

public class GameState extends State<Play>{

    public GameState(Play play){
        super(play);
    }
    public Controller getController(){
        return new PlayController(getContext());
    }
    public Drawer getDrawer() {
        return new GameDrawer(getContext());
    }
}

