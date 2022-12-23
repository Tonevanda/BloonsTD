package base.ScreenLoader;


import base.model.game.Gameplay.Position;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.event.KeyEvent;

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

    @Test
    void mousePressed(){
        Position pos = Mockito.mock(Position.class);
        Position nullPos = new Position(-1,-1);

        screenLoader.setMousePressed(pos);
        assertEquals(pos, screenLoader.getMousePressed());
        assertEquals(nullPos, screenLoader.getMousePressed());
    }
    @Test
    void mouseLocation(){
        Position pos = Mockito.mock(Position.class);

        screenLoader.setMouseLocation(pos);
        assertEquals(pos, screenLoader.getMouseLocation());
    }
    @Test
    void keyPressed(){
        int key = KeyEvent.VK_ESCAPE;

        screenLoader.setPressedKey(key);
        assertEquals(key, screenLoader.getPressedKey());
        assertEquals(-1, screenLoader.getPressedKey());
    }
}
