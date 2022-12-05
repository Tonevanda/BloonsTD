package Monkey;

import com.googlecode.lanterna.graphics.TextGraphics;

public class BombTower extends Towers {
    BombTower(){
        range = 200;
        value = 720;
        upgrades = new Upgrades();
    }
    public void draw(TextGraphics graphics) {}

    public int price() {
        return 900;
    }

    public boolean upgradeLeft() { //mais range de impacto da bomba
        if(!upgrades.upgradeLeft()) return false;
        if(upgrades.left == 1){
            //range = 150;
            value += 520;
        }
        else if(upgrades.left == 2){
            //range = 200;
            value += 640;
        }
        return true;
    }

    public boolean upgradeRight() { //mais range
        if(!upgrades.upgradeRight()) return false;
        if(upgrades.right == 1){
            range += 100;
            value += 200;
        }
        else if(upgrades.right == 2){
            range += 100;
            value += 300;
        }
        return true;
    }
}
