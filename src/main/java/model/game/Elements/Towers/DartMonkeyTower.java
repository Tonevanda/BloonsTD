package model.game.Elements.Towers;

import base.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

public class DartMonkeyTower extends Towers {
    public DartMonkeyTower() {
        radius = 50;
        value = 100;
        shootingWaitTime = 5000;
        isPlaced = false;
        upgrades = new Upgrades();
    }

    public String getFileName(){
        return "monkey/DartMonkeyTowerSprite";
    }

    public int price() {
        return 250;
    }

    public boolean upgradeLeft(){ //mais attack speed //
        if(!upgrades.upgradeLeft()) return false;
        value += 168;
        return true;
    }
    public boolean upgradeRight() { //mais range//
        if(!upgrades.upgradeRight()) return false;
        radius = 20;
        value += 80;
        return true;
    }

}
