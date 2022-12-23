package base.drawer.game;

import base.ScreenLoader.ScreenLoader;
import base.model.game.Elements.Towers.Tower;

public class TowerDrawer implements ElementDrawer<Tower> {
    @Override
    public void draw(Tower element, ScreenLoader screen) {
        screen.drawTower(element);
        if(element.isSelected()){
            screen.drawBuyMenu(element);
        }
    }
}
