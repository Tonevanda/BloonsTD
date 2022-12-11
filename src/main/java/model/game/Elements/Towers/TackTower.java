package model.game.Elements.Towers;

import com.googlecode.lanterna.graphics.TextGraphics;

public class TackTower extends Towers {
    public TackTower(){
        radius = 20;
        value = 320;
        shootingWaitTime = 7000;
        isPlaced = false;
        upgrades = new Upgrades();
    }

    public String getFileName(){
        return "monkey/TackTowerSprite";
    }


    public int price() {
        return 400;
    }

    public boolean upgradeLeft() { //mais attack speed
        if(!upgrades.upgradeLeft()) return false;
        value += 200;
        return true;
    }

    public boolean upgradeRight() { // mais range
        if(!upgrades.upgradeRight()) return false;
        radius += 20;
        value += 120;
        return true;
    }
}
