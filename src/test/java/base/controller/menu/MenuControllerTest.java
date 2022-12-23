package base.controller.menu;

import base.Application;
import base.controller.menu.MenuController;
import base.model.game.Gameplay.Position;
import base.model.menu.Menu;
import base.states.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

public class MenuControllerTest {
    Application app;
    Menu menu;
    MainMenuState mainMenuState;
    MenuController menuController;


    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        app = new Application();
        menu = new Menu();
        mainMenuState = new MainMenuState(menu);
        menuController = new MenuController(menu);
    }

    @Test
    void checkEnterGame(){
        app.setState(mainMenuState);
        assertEquals(mainMenuState, app.getState());

        Position pos = Mockito.mock(Position.class);
        when(pos.isBetween(Mockito.any(Position.class), Mockito.any(Position.class))).thenReturn(true);

        menuController.step(app, pos, pos, -1, 100);
        assertNotEquals(mainMenuState, app.getState());
    }

    @Test
    void checkQuitEsc(){
        app.setState(mainMenuState);
        assertEquals(mainMenuState, app.getState());

        Position pos = Mockito.mock(Position.class);
        when(pos.isBetween(Mockito.any(Position.class), Mockito.any(Position.class))).thenReturn(false);

        menuController.step(app, pos, pos, KeyEvent.VK_ESCAPE, 100);
        assertEquals(null, app.getState());
    }

    @Test
    void checkQuitButton(){
        app.setState(mainMenuState);
        assertEquals(mainMenuState, app.getState());

        Position pos = new Position(374,456);

        menuController.step(app, pos, pos, KeyEvent.VK_ESCAPE, 100);
        assertEquals(null, app.getState());
    }

}
