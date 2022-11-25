package Monkey;

import base.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

public class IceTower implements Towers{
    private Position coords;
    private Upgrades upgrades;
    private int range;
    private int value; // valor de venda

    IceTower(){
        range = 100;
        value = 680;
        upgrades = new Upgrades();
    }

    public void setPosition(Position pos) {
        coords = pos;
    }

    public Position getPosition() {
        return coords;
    }

    public void draw(TextGraphics graphics) {

    }

    public int getRange(){
        return range;
    }

    public int getValue(){
        return value;
    }

    public int price() {
        return 850;
    }
    public Upgrades getUpgrades(){
        return upgrades;
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
    public Position getRadius(){
        Position newPos = coords;
        newPos.setX(coords.getX()+range);
        newPos.setY(coords.getY()+range);
        return newPos;
    }
}
