package Monkey;

import base.Position;
import com.Tiago27Cruz.hero.Towers;
import com.googlecode.lanterna.graphics.TextGraphics;

public class IceTower extends Towers {
    private Position coords;
    private Upgrades upgrades;
    private int range;
    private int value; // valor de venda

    IceTower(){
        range = 100;
        value = 680;
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
            range+=100;
            value+=240;
        }
        if(upgrades.right == 2){
            range+=150;
            value+=280;
        }
        return true;
    }
}
