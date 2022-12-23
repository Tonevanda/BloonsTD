package base.model.game.Elements.Towers;

public class IceTower extends Tower {
    public IceTower(){
        radius = 30;
        value = 400;
        shootingWaitTime = 7000;
        isSelected = false;
        upgrades = new Upgrades();
        size = 60;
        selectedSize = 60;
        canPopHard = false;
        poppingPower = 2;
        lastShot = 0;
        rangeFile = "ranges/IceTowerBaseRange";
    }

    public String getFileName(){
        if(isSelected) return rangeFile;
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

    public int getUpgradePrice(char side){
        switch(side){
            case 'L': return 500;
            case 'R': return 350;
        }
        return 0;
    }
    public boolean upgradeLeft() {
        if(!upgrades.upgradeLeft()) return false;
        canPopHard = true;
        value += 360;
        return true;
    }

    public boolean upgradeRight(){
        if(!upgrades.upgradeRight()) return false;
        selectedSize = 70;
        size = 70;
        rangeFile = "ranges/IceTowerUpgradedRange";
        radius += 15;
        value += 240;
        return true;
    }
    public boolean canShootMultiple(){
        return true;
    }

}
