package model.game.Elements.Towers;

public class IceTower extends Towers {
    public IceTower(){
        radius = 30;
        value = 400;
        shootingWaitTime = 6000;
        isSelected = false;
        upgrades = new Upgrades();
        size = 60;
        selectedSize = 60;
        canPopHard = false;
        poppingPower = 1;
    }

    public String getFileName(){
        if(isSelected) return "ranges/IceTowerBaseRange";
        return "monkey/IceTowerSprite";
    }
    public String getBuyFileName(){
        return "menuBuy/MenuIce";
    }

    public void select(){
        size = selectedSize;
        isSelected = true;
    }
    public int price() {
        return 650;
    }

    public boolean upgradeLeft() {
        if(!upgrades.upgradeLeft()) return false;
        canPopHard = true;
        value += 360;
        return true;
    }

    public boolean upgradeRight() { //mais range de slow//
        if(!upgrades.upgradeRight()) return false;
        radius += 15;
        value += 240;
        return true;
    }
    public boolean canShootMultiple(){
        return true;
    }

}
