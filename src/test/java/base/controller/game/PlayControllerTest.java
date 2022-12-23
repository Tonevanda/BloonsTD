package base.controller.game;

import base.Application;
import base.controller.game.PlayController;
import base.model.game.Gameplay.Play;
import base.model.game.Gameplay.Position;
import base.states.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

public class PlayControllerTest {
    Application app;
    Play play;
    GameState gameState;
    PlayController playController;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        app = new Application();
        play = Mockito.mock(Play.class);
        gameState = new GameState(play);
        playController = new PlayController(play);
    }

    @Test
    void checkGoBackButton(){
        app.setState(gameState);
        assertEquals(gameState, app.getState());

        Position pos = Mockito.mock(Position.class);
        when(pos.isBetween(Mockito.any(Position.class), Mockito.any(Position.class))).thenReturn(true);

        playController.step(app, pos, pos, -1, 1);

        assertNotEquals(gameState, app.getState());
    }

    @Test
    void checkEndOfLives(){
        app.setState(gameState);
        assertEquals(gameState, app.getState());

        Position pos = Mockito.mock(Position.class);
        when(pos.isBetween(Mockito.any(Position.class), Mockito.any(Position.class))).thenReturn(false);

        when(play.isAlive()).thenReturn(false);

        playController.step(app, pos, pos, -1, 1);

        assertNotEquals(gameState, app.getState());
    }
}
