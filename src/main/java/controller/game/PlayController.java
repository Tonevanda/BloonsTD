package controller.game;

import base.Application;
import base.Play;
import base.Position;
import model.menu.Menu;
import states.MainMenuState;


public class PlayController extends GameController {
    private final BloonController bloonController;
    private final TowerController towerController;
    public PlayController(Play play){
        super(play);

        this.bloonController = new BloonController(play);
        this.towerController = new TowerController(play);
    }

    public void step(Application application, Position mousePressed, long time){
        if(!getModel().isAlive() || (mousePressed.getX() >=944 && mousePressed.getX() <= 1001 && mousePressed.getY() >= 22 && mousePressed.getY() <= 73)){
            application.setState(new MainMenuState(new Menu()));
        }
        else{
            bloonController.step(application,mousePressed,time);
            towerController.step(application,mousePressed,time);
        }
    }
}
