package drawer.game;

import ScreenLoader.ScreenLoader;
import base.Play;
import base.Position;
import drawer.Drawer;

import java.util.List;

public class GameDrawer extends Drawer<Play> {
    public GameDrawer(Play play) {
        super(play);
    }

    public void drawElements(ScreenLoader screen) {
        drawArena(screen);
        drawElements(screen, getModel().getBloons(), new BloonDrawer());
        drawElements(screen, getModel().getTowers(), new TowersDrawer());
        screen.drawRound(getModel().getRound());
        screen.drawLives(getModel().getPlayer().getLives());
        screen.drawText(new Position(0, 0), "Round: " + getModel().getRound(), "#FFD700");
    }

    private <T> void drawElements(ScreenLoader screen, List<T> elements, ElementDrawer<T> viewer) {
        for (T element : elements)
            drawElement(screen, element, viewer);
    }

    private <T> void drawElement(ScreenLoader screen, T element, ElementDrawer<T> drawer) {
        drawer.draw(element, screen);
    }

    private void drawArena(ScreenLoader screen) {
        screen.drawArena();
    }

}
