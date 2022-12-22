package base.drawer.menu;

import base.ScreenLoader.ScreenLoader;
import base.drawer.Drawer;
import base.model.menu.Menu;

public class MainMenuDrawer extends Drawer {
    public MainMenuDrawer(Menu menu) {
        super(menu);
    }
    public void drawElements(ScreenLoader screen){
        screen.drawMenu(256,144);
    }
}
