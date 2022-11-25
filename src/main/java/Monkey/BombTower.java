package Monkey;

import base.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

public class BombTower implements Towers{
    private Position coords;
    private Upgrades upgrades;
    private int range;
    private int value; // valor de venda

    BombTower(){
        range = 200;
        value = 720;
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
        return 900;
    }
    public Upgrades getUpgrades(){
        return upgrades;
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
    public Position getRadius(){
        Position newPos = coords;
        newPos.setX(coords.getX()+range);
        newPos.setY(coords.getY()+range);
        return newPos;
    }
}
