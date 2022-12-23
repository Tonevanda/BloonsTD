package base.model.game.Elements.Towers;

public class TackTower extends Tower {
    public TackTower(){
        radius = 25;
        value = 320;
        shootingWaitTime = 5000;
        isSelected = false;
        size = 50;
        selectedSize = 50;
        lastShot = 0;
        upgrades = new Upgrades();
        canPopHard = false;
        poppingPower = 1;
        rangeFile = "ranges/TackTowerBaseRange";
    }


    public String getFileName(){
        if(isSelected) return rangeFile;
        return "monkey/TackTowerSprite";
    }
    public String getBuyFileName(){
        return "menuBuy/MenuTack";
    }

    public void select(){
        size = selectedSize;
        isSelected = true;
    }

    public int price() {
        return 400;
    }

    public int getUpgradePrice(char side){
        switch(side){
            case 'L': return 300;
            case 'R': return 200;
        }
        return 0;
    }
    public boolean upgradeLeft() { //mais attack speed
        if(!upgrades.upgradeLeft()) return false;
        shootingWaitTime -= 2000;
        value += 100;
        return true;
    }


    public boolean upgradeRight() { // mais range
        if(!upgrades.upgradeRight()) return false;
        selectedSize = 80;
        size = 80;
        rangeFile = "ranges/TackTowerUpgradedRange";
        radius += 15;
        value += 120;
        return true;
    }
    public boolean canShootMultiple(){
        return true;
    }
}
