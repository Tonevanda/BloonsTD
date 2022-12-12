package model.game.Elements.Towers;

public class BombTower extends Towers {
    public BombTower(){
        radius = 45;
        value = 720;
        shootingWaitTime = 7000;
        isSelected = false;
        upgrades = new Upgrades();
        size = 90;
        selectedSize = 90;
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

    public boolean upgradeLeft() { //mais range de impacto da bomba
        if(!upgrades.upgradeLeft()) return false;
        //range = 150;
        value += 520;
        return true;
    }

    public boolean upgradeRight() { //mais range
        if(!upgrades.upgradeRight()) return false;
        radius += 10;
        value += 200;
        return true;
    }

}
