package controller.game;

import base.Application;
import model.game.Elements.Bloon;
import base.Play;
import base.Position;

public class BloonController extends GameController {
    public BloonController(Play play){
        super(play);
    }

    public void step(Application application, Position mousePressed, long time){
        for(Bloon bloon : getModel().getBloons()){
            //if(time - bloon.getSpeed)
            System.out.println("moving bloon");
            moveBloon(bloon, bloon.getPosition().getNextPosition());
        }
    }

    private void moveBloon(Bloon bloon, Position position){
        bloon.setPosition(position);
    }
}
