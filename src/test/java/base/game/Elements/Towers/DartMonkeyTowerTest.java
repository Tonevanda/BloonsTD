package base.game.Elements.Towers;

import base.model.game.Elements.Towers.DartMonkeyTower;
import base.model.game.Elements.Towers.Tower;
import base.model.game.Elements.Towers.Upgrades;
import base.model.game.Gameplay.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DartMonkeyTowerTest {
    @Test
    public void DartMonkeyTower(){

        DartMonkeyTower monkey = new DartMonkeyTower();

        assertEquals(35, monkey.getRadius());

        assertEquals(100, monkey.getValue());

        monkey.setLastShot(2000);
        assertFalse(monkey.canShoot(5000));
        assertFalse(monkey.canShoot(6000));
        assertTrue(monkey.canShoot(7000));

        assertFalse(monkey.isSelected());
        assertEquals(70,monkey.getSize());
        monkey.select();
        assertTrue(monkey.isSelected());
        assertEquals(70,monkey.getSize());

        assertFalse(monkey.canPopHard());
        
        assertEquals(1,monkey.getPoppingPower());
    }

    @Test
    public void Price(){
        DartMonkeyTower monkey = new DartMonkeyTower();
        assertEquals(250, monkey.price());
    }

    @Test
    public void upgradeLeft(){
        DartMonkeyTower monkey = new DartMonkeyTower();
        Upgrades upgrade = new Upgrades();
        assertEquals(upgrade, monkey.getUpgrades());

        upgrade.upgradeLeft();
        assertNotEquals(upgrade, monkey.getUpgrades());

        assertTrue(monkey.upgradeLeft());
        assertEquals(upgrade, monkey.getUpgrades());
        monkey.setLastShot(2000);
        assertFalse(monkey.canShoot(3000));
        assertTrue(monkey.canShoot(5000));
        assertEquals(100+100, monkey.getValue());
        assertFalse(monkey.upgradeLeft());
        upgrade.upgradeLeft();
        assertEquals(upgrade, monkey.getUpgrades());
        assertFalse(monkey.canShoot(3000));
        assertTrue(monkey.canShoot(5000));
        assertEquals(100+100, monkey.getValue());
    }

    @Test
    public void upgradeRight(){
        DartMonkeyTower monkey = new DartMonkeyTower();
        Upgrades upgrade = new Upgrades();
        assertEquals(upgrade, monkey.getUpgrades());

        upgrade.upgradeRight();
        assertNotEquals(upgrade, monkey.getUpgrades());
        assertTrue(monkey.upgradeRight());
        assertEquals(upgrade, monkey.getUpgrades());
        assertEquals(35+21,monkey.getRadius());
        assertEquals(100+80, monkey.getValue());
        assertEquals(112,monkey.getSize());

        assertFalse(monkey.upgradeRight());
        upgrade.upgradeRight();
        assertEquals(upgrade, monkey.getUpgrades());
        assertEquals(35+21,monkey.getRadius());
        assertEquals(100+80, monkey.getValue());
        assertEquals(112,monkey.getSize());
    }
    @Test
    public void getFileName(){
        Tower Dart = new DartMonkeyTower();
        assertEquals("monkey/DartMonkeyTowerSprite", Dart.getFileName());

        Dart.select();
        assertEquals("ranges/DartMonkeyBaseRange", Dart.getFileName());
    }
    @Test
    public void getBuyFileName(){
        Tower Dart = new DartMonkeyTower();
        assertEquals("menuBuy/MenuDart", Dart.getBuyFileName());
    }

    @Test
    public void getUpgradePrDart(){
        Tower Dart = new DartMonkeyTower();
        assertEquals(150, Dart.getUpgradePrice('L'));
        assertEquals(120, Dart.getUpgradePrice('R'));
        assertEquals(0, Dart.getUpgradePrice('M'));
    }
    @Test
    public void canShootMultiple(){
        Tower Dart = new DartMonkeyTower();
        assertFalse(Dart.canShootMultiple());
    }
    @Test
    public void setPosition(){
        Tower Dart = new DartMonkeyTower();
        Dart.setPosition(new Position(0,0));
        assertEquals(new Position(2,2),Dart.getPosition());
    }
}
