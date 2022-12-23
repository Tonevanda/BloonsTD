package base.controller.game;

import base.Application;
import base.model.game.Elements.Bloon;
import base.model.game.Gameplay.Play;
import base.model.game.Gameplay.Position;

public class BloonController extends GameController {
    private int bloonsToSend;

    public BloonController(Play play) {
        super(play);
        bloonsToSend = 1;
    }

    public int getBloonsToSend() {
        return bloonsToSend;
    }

    public void step(Application application, Position mousePressed, Position mouseLocation, Integer keyPressed, long time) {
        for (int i = 0; i < bloonsToSend; i++) {
            int numberOfBloons = getModel().getBloons().size();
            Bloon bloon = getModel().getBloons().get(i);
            getModel().popBloon(time, bloonsToSend);

            Position nextPosition = bloon.getPosition().getNextPosition();
            bloon.setPosition(nextPosition);

            sendAnotherBloon(bloon, i);
            checkBloonRemoved(bloon, numberOfBloons);
        }
        checkEndofRound();

    }

    public void sendAnotherBloon(Bloon bloon, int i){
        Position farEnough = new Position(5, 48);
        if (bloon.getPosition().equals(farEnough) && i < getModel().getBloons().size() - 1) {
            bloonsToSend++;
        }
    }
    public void checkBloonRemoved(Bloon bloon, int numberOfBloons){
        Position atEnd = new Position(161, -29);
        boolean bloonAtEnd = bloon.getPosition().equals(atEnd);
        boolean bloonsPopped = getModel().getBloons().size() < numberOfBloons;

        if (bloonAtEnd) {
            getModel().getPlayer().loseLives(bloon.getLayers());
            getModel().removeBloon(bloon);
            bloonsToSend--;
        }
        else if (bloonsPopped) {
            bloonsToSend -= (numberOfBloons - getModel().getBloons().size());
        }
    }
    public void checkEndofRound() {
        boolean finishedRound = bloonsToSend == 0 && getModel().hasRoundEnded();
        boolean poppedAllScreenBloons = bloonsToSend == 0;

        if (finishedRound) {
            getModel().nextRound();
            bloonsToSend = 1;
        } else if (poppedAllScreenBloons) {
            bloonsToSend = 1;
        }
    }
}