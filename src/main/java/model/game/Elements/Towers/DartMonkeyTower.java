package model.game.Elements.Towers;

import base.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

public class DartMonkeyTower extends Towers {
    public DartMonkeyTower() {
        radius = 35;
        value = 100;
        shootingWaitTime = 4000;
        isSelected = false;
        size = 70;
        selectedSize = 70;
        upgrades = new Upgrades();
        canPopHard = false;
        poppingPower = 1;
        lastShot = 0;
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

    public boolean upgradeLeft(){
        if(!upgrades.upgradeLeft()) return false;
        shootingWaitTime -= 2000;
        value += 168;
        return true;
    }
    public boolean upgradeRight() {
        if(!upgrades.upgradeRight()) return false;
        selectedSize = 112;

        radius = 56;
        value += 80;
        return true;
    }
    public boolean canShootMultiple(){
        return false;
    }
}
