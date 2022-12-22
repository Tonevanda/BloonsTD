package controller;

import base.controller.game.BloonController;
import base.model.game.Elements.Bloon;
import base.model.game.Gameplay.Play;
import base.model.game.Gameplay.Player;
import base.model.game.Gameplay.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BloonControllerTest {
    BloonController bloonController;
    Play play;
    List<Bloon> bloons;
    Bloon bloon;

    @BeforeEach
    public void setUp(){
        play = mock(Play.class);
        bloonController = new BloonController(play);
        bloon= new Bloon("red");
        bloon.setPosition(new Position(0,0));
        bloons = new ArrayList<>();
        bloons.add(bloon);
        when(play.getBloons()).thenReturn(bloons);
    }

    @Test
    public void BloonController(){
        assertEquals(1, bloonController.getBloonsToSend());
    }

    @Test
    public void sendAnotherBloonRemove(){
        Bloon bloon2= new Bloon("red");
        bloon2.setPosition(new Position(0,0));
        bloons.add(bloon2);

        Position pos = new Position(5,48);
        bloon.setPosition(pos);
        bloonController.sendAnotherBloon(bloon, 0);

        assertEquals(2,bloonController.getBloonsToSend());

        Position atEnd = new Position(161, -29);
        bloon2.setPosition(atEnd);
        when(play.getPlayer()).thenReturn(mock(Player.class));
        bloonController.checkBloonRemoved(bloon2, 2);

        assertEquals(1,bloonController.getBloonsToSend());
    }

    @Test
    public void checkEndofRound() {
        Position atEnd = new Position(161, -29);
        bloon.setPosition(atEnd);
        when(play.getPlayer()).thenReturn(mock(Player.class));
        bloonController.checkBloonRemoved(bloon, 1);
        assertEquals(0,bloonController.getBloonsToSend());
        bloonController.checkEndofRound();
        assertEquals(1, bloonController.getBloonsToSend());
    }
}
