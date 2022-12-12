package model.game.Elements.Towers;

import com.googlecode.lanterna.graphics.TextGraphics;

public class TackTower extends Towers {
    public TackTower(){
        radius = 25;
        value = 320;
        shootingWaitTime = 7000;
        isSelected = false;
        size = 50;
        selectedSize = 50;
        upgrades = new Upgrades();
    }


    public String getFileName(){
        if(isSelected)return "ranges/TackTowerBaseRange";
        return "monkey/TackTowerSprite";
    }
    public String getBuyFileName(){
        return "menuBuy/MenuTack";
    }

    public void select(){
        size = selectedSize;
        isSelected = true;
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
