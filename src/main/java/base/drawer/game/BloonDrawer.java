package base.drawer.game;

import base.ScreenLoader.ScreenLoader;
import base.model.game.Elements.Bloon;


public class BloonDrawer implements ElementDrawer<Bloon>{
    public void draw(Bloon bloon, ScreenLoader screen){
        screen.drawBloon(bloon.getPosition(), bloon);
    }
}
