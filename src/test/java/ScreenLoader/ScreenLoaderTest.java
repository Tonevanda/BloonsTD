package ScreenLoader;

import base.ScreenLoader.ScreenLoader;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class ScreenLoaderTest {
    private Screen screen;
    private ScreenLoader screenLoader;

    @BeforeEach
    void setUp(){
        screen = mock(Screen.class);
        screenLoader = new ScreenLoader(screen);
    }

    @Test
    public void getScreen(){
        assertEquals(screen, screenLoader.getScreen());
    }
}
