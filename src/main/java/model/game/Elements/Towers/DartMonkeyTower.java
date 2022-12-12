package model.game.Elements.Towers;

import base.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

public class DartMonkeyTower extends Towers {
    public DartMonkeyTower() {
        radius = 35;
        value = 100;
        shootingWaitTime = 5000;
        isSelected = false;
        size = 70;
        selectedSize = 70;
        upgrades = new Upgrades();
    }
    public void select(){
        size = selectedSize;
        isSelected = true;
    }

    public String getFileName(){
        if(isSelected) return "ranges/DartMonkeyBaseRange";
        return "monkey/DartMonkeyTowerSprite";
    }
    public String getBuyFileName(){
        return "menuBuy/MenuDart";
    }
    public int price() {
        return 250;
    }

    public boolean upgradeLeft(){ //mais attack speed
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
