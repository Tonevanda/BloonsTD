package drawer.game;

import ScreenLoader.ScreenLoader;
import base.Play;
import drawer.Drawer;

public abstract class GameDrawer extends Drawer<Play> {
    public GameDrawer(Play play) {
        super(play);
    }
}
