package Monkey;

import com.googlecode.lanterna.graphics.TextGraphics;

public class DartMonkeyTower extends Towers {
    DartMonkeyTower() {
        range = 120;
        value = 100;
        upgrades = new Upgrades();
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
            range = 150;
            value += 80;
        } else if (upgrades.right == 2) {
            range = 200;
            value += 90;
        }
        return true;
    }
}
