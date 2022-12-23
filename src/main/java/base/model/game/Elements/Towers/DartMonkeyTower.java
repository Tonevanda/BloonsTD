package base.model.game.Elements.Towers;

public class DartMonkeyTower extends Tower {
    public DartMonkeyTower() {
        radius = 35;
        value = 100;
        shootingWaitTime = 4000;
        isSelected = false;
        size = 70;
        selectedSize = 70;
        upgrades = new Upgrades();
        canPopHard = false;
        poppingPower = 1;
        lastShot = 0;
        rangeFile = "ranges/DartMonkeyBaseRange";
    }
    public void select(){
        size = selectedSize;
        isSelected = true;
    }

    public String getFileName(){
        if(isSelected) return rangeFile;
        return "monkey/DartMonkeyTowerSprite";
    }
    public String getBuyFileName(){
        return "menuBuy/MenuDart";
    }
    public int price() {
        return 250;
    }

    public int getUpgradePrice(char side){
        switch(side){
            case 'L': return 150;
            case 'R': return 120;
        }
        return 0;
    }

    public boolean upgradeLeft(){
        if(!upgrades.upgradeLeft()) return false;
        shootingWaitTime -= 2000;
        value += 100;
        return true;
    }
    public boolean upgradeRight() {
        if(!upgrades.upgradeRight()) return false;
        selectedSize = 112;
        size = 112;
        rangeFile = "ranges/DartMonkeyUpgradedRange";
        radius = 56;
        value += 80;
        return true;
    }
    public boolean canShootMultiple(){
        return false;
    }
}
