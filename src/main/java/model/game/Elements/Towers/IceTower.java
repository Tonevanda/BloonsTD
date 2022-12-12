package model.game.Elements.Towers;

public class IceTower extends Towers {
    public IceTower(){
        radius = 30;
        value = 400;
        shootingWaitTime = 7000;
        isSelected = false;
        upgrades = new Upgrades();
        size = 60;
        selectedSize = 60;
    }

    public String getFileName(){
        if(isSelected) return "ranges/BombTowerBaseRange";
        return "monkey/IceTowerSprite";
    }

    public void select(){
        size = selectedSize;
        isSelected = true;
    }
    public int price() {
        return 650;
    }

    public boolean upgradeLeft() { //mais quantidade de slow//
        if(!upgrades.upgradeLeft()) return false;
        value += 360;
        return true;
    }

    public boolean upgradeRight() { //mais range de slow//
        if(!upgrades.upgradeRight()) return false;
        radius += 10;
        value += 240;
        return true;
    }

}
