package base.drawer.game;

import base.ScreenLoader.ScreenLoader;
import base.model.game.Gameplay.Play;

public class PlayerStatsDrawer implements ElementDrawer<Play> {

    public void draw(Play element, ScreenLoader screen){
        screen.drawRound(element.getRound());
        screen.drawMoney(element.getPlayer().getMoney());
        screen.drawLives(element.getPlayer().getLives());
    }
}
