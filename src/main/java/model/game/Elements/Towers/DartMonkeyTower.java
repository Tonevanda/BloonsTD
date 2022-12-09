package model.game.Elements.Towers;

import com.googlecode.lanterna.graphics.TextGraphics;

public class DartMonkeyTower extends Towers {
    public DartMonkeyTower() {
        radius = 120;
        value = 100;
        upgrades = new Upgrades();
    }

    public String getFileName(){
        return "monkey/16";
    }

    public void draw(TextGraphics graphics) {

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
