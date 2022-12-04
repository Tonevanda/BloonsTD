package Monkey;

import base.Position;
import com.Tiago27Cruz.hero.Towers;
import com.googlecode.lanterna.graphics.TextGraphics;

public class BombTower extends Towers {
    private Position coords;
    private Upgrades upgrades;
    private int range;
    private int value;

    BombTower(){
        range = 200;
        value = 720;
        upgrades = new Upgrades();
    }
    public void draw(TextGraphics graphics) {

    }
    public void setPosition(Position pos) {
        coords = pos;
    }

    public Position getPosition() {
        return coords;
    }
    public int getRange(){
        return range;
    }

    public int getValue(){
        return value;
    }
    public Upgrades getUpgrades(){
        return upgrades;
    }
    public Position getRadius(){
        Position newPos = coords;
        newPos.setX(coords.getX()+range);
        newPos.setY(coords.getY()+range);
        return newPos;
    }

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
