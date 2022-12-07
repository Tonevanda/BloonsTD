package drawer.game;

import ScreenLoader.ScreenLoader;
import base.Bloon;
import base.Play;

import java.util.List;

public class BloonDrawer extends GameDrawer{
    public BloonDrawer(Play play){
        super(play);
    }
    protected void drawElements(ScreenLoader screen){
        List<Bloon> bloons = getModel().getBloons();
        for(Bloon bloon : bloons){
            screen.drawBloon(bloon.getCoords(), bloon);
        }
    }
}
