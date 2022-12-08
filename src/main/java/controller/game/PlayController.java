package controller.game;

import base.Application;
import base.Play;
import base.Position;
import model.menu.Menu;
import states.MainMenuState;


public class PlayController extends GameController {
    private final BloonController bloonController;
    public PlayController(Play play){
        super(play);

        this.bloonController = new BloonController(play);
    }

    public void step(Application application, Position mousePressed, long time){
        if(!getModel().isAlive()){
            application.setState(new MainMenuState(new Menu()));
        }
        else{
            bloonController.step(application,mousePressed,time);
        }
    }
}
