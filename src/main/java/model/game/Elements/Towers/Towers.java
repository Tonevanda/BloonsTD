package model.game.Elements.Towers;

import base.Position;

public abstract class Towers {
    protected Position position;
    protected Upgrades upgrades;
    protected int radius;
    protected int value;
    protected long lastShot;
    protected int shootingWaitTime;
    protected boolean isPlaced;


    public void setPosition(Position pos) {
        Position terminalPosition = new Position(pos.getX()/4, pos.getY()/4);
        position = terminalPosition;
    }
    public Position getPosition() {
        return position;
    }
    public int getRadius(){
        return radius;
    }

    public int getValue(){
        return value;
    }
    public boolean isPlaced(){
        return isPlaced;
    }
    public void Place(){
        isPlaced = true;
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

    public abstract String getFileName();
    public abstract int price();
    public abstract boolean upgradeLeft();
    public abstract boolean upgradeRight();
}
