package base.drawer;

import base.ScreenLoader.ScreenLoader;
import base.drawer.game.GameDrawer;
import base.drawer.menu.MainMenuDrawer;
import base.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class MainMenuDrawerTest {
    Menu menu;
    ScreenLoader screen;
    MainMenuDrawer drawer;

    @BeforeEach
    void setUp(){
        menu = new Menu();
        screen = mock(ScreenLoader.class);
        drawer = new MainMenuDrawer(menu);
    }

    @Test
    void drawMainMenu(){
        drawer.drawElements(screen);

        Mockito.verify(screen, times(1)).drawMenu(256,144);
    }
}
