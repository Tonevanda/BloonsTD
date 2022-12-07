package drawer.game;

import ScreenLoader.ScreenLoader;
import base.Bloon;
import base.Play;

import java.util.List;

public class ArenaDrawer extends GameDrawer {
    public ArenaDrawer(Play play){
        super(play);
    }
    protected void drawElements(ScreenLoader screen){
        screen.drawArena();
    }
}
