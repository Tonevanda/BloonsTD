package base.controller.game;

import base.Application;
import base.model.game.Gameplay.Play;
import base.model.game.Gameplay.Position;
import base.model.menu.Menu;
import base.states.MainMenuState;


public class PlayController extends GameController {
    private final BloonController bloonController;
    private final TowerController towerController;
    public PlayController(Play play){
        super(play);

        this.bloonController = new BloonController(play);
        this.towerController = new TowerController(play);
    }

    public void step(Application application, Position mousePressed, Position mouseLocation, Integer keyPressed, long time){
        boolean pressedGoBack = mousePressed.isBetween(new Position(944, 22), new Position(1001, 72));
        boolean gameWon = getModel().getRound() == 16;

        if(!getModel().isAlive() || pressedGoBack || gameWon){
            application.setState(new MainMenuState(new Menu()));
        }
        else{
            bloonController.step(application,mousePressed,mouseLocation, keyPressed, time);
            towerController.step(application,mousePressed,mouseLocation, keyPressed, time);
        }
    }
}
