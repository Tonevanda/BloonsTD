package com.Tiago27Cruz.hero;

import Monkey.Upgrades;
import base.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Towers {
    private Position coords;
    private Upgrades upgrades;
    private int range;
    private int value;

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
    public abstract int price();
    public abstract boolean upgradeLeft();
    public abstract boolean upgradeRight();
    public abstract void draw(TextGraphics graphics);


}
