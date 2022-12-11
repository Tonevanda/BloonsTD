package model.game.Elements.Towers;

import com.googlecode.lanterna.graphics.TextGraphics;

public class BombTower extends Towers {
    public BombTower(){
        radius = 30;
        value = 720;
        shootingWaitTime = 7000;
        isSelected = false;
        upgrades = new Upgrades();
    }

    public String getFileName(){
        return "monkey/BombTowerSprite";
    }

    public int price() {
        return 900;
    }

    public boolean upgradeLeft() { //mais range de impacto da bomba
        if(!upgrades.upgradeLeft()) return false;
        //range = 150;
        value += 520;
        return true;
    }

    public boolean upgradeRight() { //mais range
        if(!upgrades.upgradeRight()) return false;
        radius += 10;
        value += 200;
        return true;
    }

}
