package model.game.Elements.Towers;

public class BombTower extends Towers {
    public BombTower(){
        radius = 45;
        value = 720;
        shootingWaitTime = 8000;
        isSelected = false;
        upgrades = new Upgrades();
        size = 90;
        selectedSize = 90;
        canPopHard = true;
        poppingPower = 1;
    }
    public void select(){
        size = selectedSize;
        isSelected = true;
    }
    public String getFileName(){
        if(isSelected) return "ranges/BombTowerBaseRange";
        return "monkey/BombTowerSprite";
    }
    public String getBuyFileName(){
        return "menuBuy/MenuBomb";
    }
    public int price() {
        return 900;
    }

    public boolean upgradeLeft() {
        if(!upgrades.upgradeLeft()) return false;
        poppingPower++;
        value += 520;
        return true;
    }

    public boolean upgradeRight() {
        if(!upgrades.upgradeRight()) return false;
        radius += 10;
        value += 200;
        return true;
    }
    public boolean canShootMultiple(){
        return false;
    }

}
