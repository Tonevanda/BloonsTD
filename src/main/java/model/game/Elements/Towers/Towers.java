package model.game.Elements.Towers;

import base.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Towers {
    protected Position coords;
    protected Upgrades upgrades;
    protected int radius;
    protected int value;


    public void setPosition(Position pos) {
        coords = pos;
    }

    public Position getPosition() {
        return coords;
    }
    public int getRadius(){
        return radius;
    }

    public int getValue(){
        return value;
    }
    public Upgrades getUpgrades(){
        return upgrades;
    }

    /*
    public Position getRange() {
        Position newPos = coords;
        newPos.setX(coords.getX() + range);
        newPos.setY(coords.getY() + range);
        return newPos;
    }
    */

    public abstract String getFileName();
    public abstract int price();
    public abstract boolean upgradeLeft();
    public abstract boolean upgradeRight();
    public abstract void draw(TextGraphics graphics);
}
