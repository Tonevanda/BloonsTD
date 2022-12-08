package controller.game;

import base.Application;
import model.game.Elements.Bloon;
import base.Play;
import base.Position;

public class BloonController extends GameController {
    private long bloonsToSend;

    public BloonController(Play play){
        super(play);
        bloonsToSend = 1;
    }

    public void step(Application application, Position mousePressed, long time){
        Position farEnough = new Position(5,48);
        Position atEnd = new Position(161,-29);

        for(int i = 0; i < bloonsToSend; i++){
            Bloon bloon = getModel().getBloons().get(i);
            if(bloon.canMove(time)){
                moveBloon(bloon, bloon.getPosition().getNextPosition());
            }
            if(bloon.getPosition().equals(farEnough) && i < getModel().getBloons().size()-1){
                bloonsToSend++;
            }
            if(bloon.getPosition().equals(atEnd)){
                getModel().getPlayer().loseHearts(bloon.getLayers());
                getModel().removeBloon(bloon);
                bloonsToSend--;
                System.out.println("Player Hearts: " + getModel().getPlayer().getLives());
            }
        }
        if(bloonsToSend==0 && getModel().hasRoundEnded()){
            getModel().nextRound();
            bloonsToSend=1;
        }
    }

    private void moveBloon(Bloon bloon, Position position){
        //System.out.println("Current Position: " + bloon.getPosition().getX() + ", " + bloon.getPosition().getY() + " New Position: " + position.getX() + ", " + position.getY());
        bloon.setPosition(position);
    }
}
