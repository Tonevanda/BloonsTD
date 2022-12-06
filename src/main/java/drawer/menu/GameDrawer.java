package drawer.menu;

import ScreenLoader.ScreenLoader;
import base.Play;
import drawer.Drawer;
import menu.Menu;

public class GameDrawer extends Drawer {
    public GameDrawer(Play play) {
        super(play);
    }
    protected void drawElements(ScreenLoader screen){
        screen.drawMenu(256,144);
    }
}
