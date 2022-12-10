package model.game.Elements.Towers;

import base.Position;

public abstract class Towers {
    protected Position coords;
    protected Upgrades upgrades;
    protected int radius;
    protected int value;
    protected long lastShot;
    protected int shootingWaitTime;


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
    public boolean canShoot(long time){
        if(time - lastShot > shootingWaitTime){
            lastShot = time;
            return true;
        }
        return false;
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
}
