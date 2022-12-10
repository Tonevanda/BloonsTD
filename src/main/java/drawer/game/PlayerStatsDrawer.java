package drawer.game;

import ScreenLoader.ScreenLoader;
import base.Play;
import base.Player;

public class PlayerStatsDrawer implements ElementDrawer<Play> {

    public void draw(Play element, ScreenLoader screen){
        screen.drawRound(element.getRound());
        screen.drawMoney(element.getPlayer().getMoney());
        screen.drawLives(element.getPlayer().getLives());
    }
}
