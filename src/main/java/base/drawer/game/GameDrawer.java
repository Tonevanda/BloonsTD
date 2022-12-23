package base.drawer.game;

import base.ScreenLoader.ScreenLoader;
import base.drawer.Drawer;
import base.model.game.Gameplay.Play;

import java.util.List;

public class GameDrawer extends Drawer<Play> {
    public GameDrawer(Play play) {
        super(play);
    }

    public void drawElements(ScreenLoader screen) {
        drawArena(screen);
        drawElements(screen, getModel().getBloons(), new BloonDrawer());
        drawElements(screen, getModel().getTowers(), new TowerDrawer());
        drawElements(screen, getModel().getPlacingTower(), new TowerDrawer());
        screen.drawRound(getModel().getRound());
        screen.drawMoney(getModel().getPlayer().getMoney());
        screen.drawLives(getModel().getPlayer().getLives());
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
