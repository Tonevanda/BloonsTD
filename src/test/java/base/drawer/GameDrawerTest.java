package base.drawer;

import base.ScreenLoader.ScreenLoader;
import base.drawer.game.GameDrawer;
import base.model.game.Elements.Bloon;
import base.model.game.Elements.Towers.Tower;
import base.model.game.Gameplay.Play;
import base.model.game.Gameplay.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class GameDrawerTest {
    Play play;
    ScreenLoader screen;
    GameDrawer drawer;

    @BeforeEach
    void setUp(){
        play = new Play();
        screen = mock(ScreenLoader.class);
        drawer = new GameDrawer(play);
    }

    @Test
    void drawArena(){
        drawer.drawElements(screen);

        Mockito.verify(screen, times(1)).drawArena();
    }

    @Test
    void drawBloons(){
        drawer.drawElements(screen);

        for(int i = 0; i < 10; i++) Mockito.verify(screen, times(1)).drawBloon(play.getBloons().get(i).getPosition(), play.getBloons().get(i));
        Mockito.verify(screen, times(10)).drawBloon(Mockito.any(Position.class), Mockito.any(Bloon.class));
    }

    @Test
    void drawTowers(){
        Tower tower = mock(Tower.class);
        play.addTower(tower);
        drawer.drawElements(screen);

        Mockito.verify(screen, times(1)).drawTower(play.getTowers().get(0));
    }

    @Test
    void drawNumbers(){
        drawer.drawElements(screen);
        Position pos = new Position(1,1);

        Mockito.verify(screen, times(1)).drawRound(play.getRound());
        Mockito.verify(screen, times(1)).drawLives(play.getPlayer().getLives());
        Mockito.verify(screen, times(1)).drawMoney(play.getPlayer().getMoney());
    }

    @Test
    void drawBuyMenu(){
        Tower tower = mock(Tower.class);
        when(tower.isSelected()).thenReturn(true);
        play.addTower(tower);
        drawer.drawElements(screen);

        Mockito.verify(screen, times(1)).drawBuyMenu(play.getTowers().get(0));
    }



    @Test
    void refreshAndClear() throws IOException {
        drawer.draw(screen);

        Mockito.verify(screen, Mockito.times(1)).clear();
        Mockito.verify(screen, Mockito.times(1)).refresh();
    }
}
