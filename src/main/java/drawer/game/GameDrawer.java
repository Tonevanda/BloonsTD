package drawer.game;

import ScreenLoader.ScreenLoader;
import base.Play;
import drawer.Drawer;

public class GameDrawer extends Drawer {
    public GameDrawer(Play play) {
        super(play);
    }
    protected void drawElements(ScreenLoader screen){
        screen.drawMenu(256,144);
    }
}
