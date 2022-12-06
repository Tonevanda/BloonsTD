package drawer.menu;

import ScreenLoader.ScreenLoader;
import drawer.Drawer;
import model.menu.Menu;

public class MainMenuDrawer extends Drawer {
    public MainMenuDrawer(Menu menu) {
        super(menu);
    }
    protected void drawElements(ScreenLoader screen){
        screen.drawMenu(256,144);
    }
}
