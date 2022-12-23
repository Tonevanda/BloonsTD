package base;

import base.Application;
import base.states.MainMenuState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest{
    @Test
    void Application() throws IOException, URISyntaxException, FontFormatException {
        Application app = new Application();

        assertNotNull(app.getState());
    }

    @Test
    void setState() throws IOException, URISyntaxException, FontFormatException {
        Application app = new Application();
        MainMenuState mainMenuState = Mockito.mock(MainMenuState.class);

        assertNotEquals(mainMenuState, app.getState());
        app.setState(mainMenuState);
        assertEquals(mainMenuState, app.getState());
    }
}
