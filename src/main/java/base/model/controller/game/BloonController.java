package base.model.controller.game;

import base.Application;
import base.model.game.Gameplay.Position;
import base.model.game.Elements.Bloon;
import base.model.game.Gameplay.Play;

public class BloonController extends GameController {
    private int bloonsToSend;

    public BloonController(Play play){
        super(play);
        bloonsToSend = 1;
    }

    public void step(Application application, Position mousePressed, Position mouseLocation, Integer keyPressed, long time){
        Position farEnough = new Position(5,48);
        Position atEnd = new Position(161,-29);


        for(int i = 0; i < bloonsToSend; i++){
            int numberOfBloons = getModel().getBloons().size();
            Bloon bloon = getModel().getBloons().get(i);
            getModel().popBloon(time, bloonsToSend);

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
            }
            else if(getModel().getBloons().size() < numberOfBloons){
                bloonsToSend -= (numberOfBloons - getModel().getBloons().size());
            }
        }

        if(bloonsToSend==0 && getModel().hasRoundEnded()){
            getModel().nextRound();
            bloonsToSend=1;
        }
        else if(bloonsToSend == 0){
            bloonsToSend = 1;
        }
    }

    private void moveBloon(Bloon bloon, Position position){
        bloon.setPosition(position);
    }
}
