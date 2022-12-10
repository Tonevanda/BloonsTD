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
        if(upgrades.left == 1){
            value += 168;
        }
        else if(upgrades.left == 2){
            value += 204;
        }
        return true;
    }
    public boolean upgradeRight() { //mais range//
        if(!upgrades.upgradeRight()) return false;
        if (upgrades.right == 1) {
            radius = 150;
            value += 80;
        } else if (upgrades.right == 2) {
            radius = 200;
            value += 90;
        }
        return true;
    }
}
