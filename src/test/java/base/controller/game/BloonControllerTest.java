package base.controller.game;

import base.model.game.Elements.Bloon;
import base.model.game.Gameplay.Play;
import base.model.game.Gameplay.Player;
import base.model.game.Gameplay.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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
    public void sendAnotherBloon(){
        Bloon bloon2= new Bloon("red");
        bloon2.setPosition(new Position(0,0));
        bloons.add(bloon2);

        Position pos = new Position(5,48);
        bloon.setPosition(pos);
        bloonController.sendAnotherBloon(bloon, 0);
        assertEquals(2,bloonController.getBloonsToSend());

        bloonController.sendAnotherBloon(bloon, 2);
        assertEquals(2,bloonController.getBloonsToSend());
    }

    @Test
    void removeBloon(){
        Position atEnd = new Position(161, -29);
        bloon.setPosition(atEnd);
        Player player = mock(Player.class);
        when(play.getPlayer()).thenReturn(player);
        bloonController.checkBloonRemoved(bloon, 2);

        assertEquals(0,bloonController.getBloonsToSend());
    }

    @Test
    public void checkPoppedScreenBloons() {
        Position atEnd = new Position(161, -29);
        bloon.setPosition(atEnd);
        when(play.getPlayer()).thenReturn(mock(Player.class));
        bloonController.checkBloonRemoved(bloon, 1);
        assertEquals(0,bloonController.getBloonsToSend());
        bloonController.checkEndofRound();
        assertEquals(1, bloonController.getBloonsToSend());
    }

    @Test
    public void checkEndOfRound(){
        Position atEnd = new Position(161, -29);
        bloon.setPosition(atEnd);
        when(play.getPlayer()).thenReturn(mock(Player.class));
        when(play.hasRoundEnded()).thenReturn(true);

        bloonController.checkBloonRemoved(bloon, 1);
        bloonController.checkEndofRound();
        verify(play, times(1)).nextRound();
        assertEquals(1, bloonController.getBloonsToSend());
    }
}

