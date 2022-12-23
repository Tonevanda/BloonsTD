package base.model.game.Elements.Towers;

import base.model.game.Gameplay.Position;

public abstract class Tower {
    protected Position position;
    public Upgrades upgrades;
    protected int radius;
    protected int value;
    protected long lastShot;
    protected int shootingWaitTime;
    protected boolean isSelected;
    protected int size;
    protected int selectedSize;
    protected boolean canPopHard;
    protected int poppingPower;
    protected String rangeFile;

    public void setPosition(Position pos) {
        position = new Position((pos.getX()+8)/4, (pos.getY()+8)/4);
    }
    public int getPoppingPower(){return poppingPower;}
    public Position getPosition() {
        return position;
    }
    public int getRadius(){
        return radius;
    }

    public int getValue(){
        return value;
    }
    public boolean isSelected() {
        return isSelected;
    }
    public void stopSelecting(){
        size = 16;
        isSelected = false;
    }
    public boolean canPopHard(){return canPopHard;}
    public Upgrades getUpgrades(){
        return upgrades;
    }
    public int getSize(){
        return size;
    }
    public void setLastShot(long time){
        lastShot = time;
    }
    public boolean canShoot(long time){
        if(time - lastShot > shootingWaitTime){
            return true;
        }
        return false;
    }

    public abstract int getUpgradePrice(char side);
    public abstract void select();
    public abstract String getFileName();
    public abstract String getBuyFileName();
    public abstract int price();
    public abstract boolean canShootMultiple();
    public abstract boolean upgradeLeft();
    public abstract boolean upgradeRight();

}
