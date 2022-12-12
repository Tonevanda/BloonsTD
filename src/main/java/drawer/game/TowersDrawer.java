package drawer.game;

import ScreenLoader.ScreenLoader;
import model.game.Elements.Towers.Towers;

public class TowersDrawer implements ElementDrawer<Towers> {
    @Override
    public void draw(Towers element, ScreenLoader screen) {
        screen.drawTower(element);
        if(element.isSelected()){
            screen.drawBuyMenu(element);
        }
    }
}
