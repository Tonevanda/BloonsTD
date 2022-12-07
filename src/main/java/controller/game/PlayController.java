package controller.game;

import base.Application;
import base.Play;
import base.Position;
import model.menu.Menu;
import states.MainMenuState;

import java.util.List;

public class PlayController extends GameController {
    public PlayController(Play play){
        super(play);
    }

    public void step(Application application, Position mousePressed, long time){
        if(!getModel().isAlive()){
            application.setState(new MainMenuState(new Menu()));
        }
        else if(getModel().hasRoundEnded()){

        }
    }
}
