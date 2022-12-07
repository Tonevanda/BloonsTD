package controller.game;

import base.Application;
import model.game.Elements.Bloon;
import base.Play;
import base.Position;

public class BloonController extends GameController {
    private long lastMovement;
    public BloonController(Play play){
        super(play);
    }

    public void step(Application application, Position mousePressed, long time){
        int i = 0;
        for(Bloon bloon : getModel().getBloons()){
            if(bloon.canMove(time)){
                moveBloon(bloon, bloon.getPosition().getNextPosition());
                this.lastMovement = time;
            }
        }
    }

    private void moveBloon(Bloon bloon, Position position){
        System.out.println("Cur Pos: " + bloon.getPosition().getX() + ", " + bloon.getPosition().getY() + " New Pos: " + position.getX() + ", " + position.getY());
        bloon.setPosition(position);
    }
}
