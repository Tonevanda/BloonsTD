package drawer.game;

import ScreenLoader.ScreenLoader;
import base.Play;
import model.game.Elements.Bloon;
import java.util.List;


public class BloonDrawer implements ElementDrawer<Bloon>{
    public void draw(Bloon bloon, ScreenLoader screen){
        screen.drawBloon(bloon.getPosition(), bloon);
    }
}
