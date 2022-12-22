package base.states;

import base.model.game.Gameplay.Play;
import base.model.controller.Controller;
import base.model.controller.game.PlayController;
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

