package model.game.Elements.Towers;

import base.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

public class IceTower extends Towers {
    public IceTower(){
        radius = 30;
        value = 680;
        shootingWaitTime = 7000;
        isPlaced = false;
        upgrades = new Upgrades();
    }

    public String getFileName(){
        return "monkey/IceTowerSprite";
    }


    public int price() {
        return 850;
    }

    public boolean upgradeLeft() { //mais quantidade de slow//
        if(!upgrades.upgradeLeft()) return false;
        value += 360;
        return true;
    }

    public boolean upgradeRight() { //mais range de slow//
        if(!upgrades.upgradeRight()) return false;
        radius += 10;
        value += 240;
        return true;
    }

}
