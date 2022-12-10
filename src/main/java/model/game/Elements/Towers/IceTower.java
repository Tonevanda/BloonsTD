package model.game.Elements.Towers;

import base.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

public class IceTower extends Towers {
    public IceTower(){
        radius = 100;
        value = 680;
        shootingWaitTime = 500;
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
        if(upgrades.left == 1){
            value += 360;
        }
        else if(upgrades.left == 2){
            value += 400;
        }
        return true;
    }

    public boolean upgradeRight() { //mais range de slow//
        if(!upgrades.upgradeRight()) return false;
        if(upgrades.right == 1){
            radius+=100;
            value+=240;
        }
        if(upgrades.right == 2){
            radius+=150;
            value+=280;
        }
        return true;
    }
}
