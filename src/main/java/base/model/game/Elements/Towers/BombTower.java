package base.model.game.Elements.Towers;

public class BombTower extends Tower {
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
        lastShot = 0;
        rangeFile ="ranges/BombTowerBaseRange";
    }
    public void select(){
        size = selectedSize;
        isSelected = true;
    }
    public String getFileName(){
        if(isSelected) return rangeFile;
        return "monkey/BombTowerSprite";
    }
    public String getBuyFileName(){
        return "menuBuy/MenuBomb";
    }
    public int price() {
        return 900;
    }

    public int getUpgradePrice(char side){
        switch(side){
            case 'L': return 750;
            case 'R': return 350;
        }
        return 0;
    }

    public boolean upgradeLeft() {
        if(!upgrades.upgradeLeft()) return false;
        poppingPower++;
        value += 520;
        return true;
    }

    public boolean upgradeRight() {
        if(!upgrades.upgradeRight()) return false;
        selectedSize = 110;
        size = 110;
        rangeFile = "ranges/BombTowerUpgradedRange";
        radius = 55;
        value += 200;
        return true;
    }
    public boolean canShootMultiple(){
        return false;
    }

}
