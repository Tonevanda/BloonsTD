package model.game.Towers;

import com.googlecode.lanterna.graphics.TextGraphics;

public class TackTower extends Towers {
    TackTower(){
        radius = 80;
        value = 320;
        upgrades = new Upgrades();
    }

    public String getFileName(){
        return "monkey/tackTower";
    }

    public void draw(TextGraphics graphics) {

    }

    public int price() {
        return 400;
    }

    public boolean upgradeLeft() { //mais attack speed
        if(!upgrades.upgradeLeft()) return false;
        if(upgrades.left == 1){
           value += 200;
        }
        else if(upgrades.left == 2){
            value += 270;
        }
        return true;
    }

    public boolean upgradeRight() { // mais range
        if(!upgrades.upgradeRight()) return false;
        if(upgrades.right == 1){
            radius+=100;
            value+=120;
        }
        if(upgrades.right == 2){
            radius+=150;
            value+=160;
        }
        return true;
    }
}
