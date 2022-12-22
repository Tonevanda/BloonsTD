package base.states;

import base.model.game.Gameplay.Play;
import base.controller.Controller;
import base.controller.game.PlayController;
import base.drawer.Drawer;
import base.drawer.game.GameDrawer;

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

