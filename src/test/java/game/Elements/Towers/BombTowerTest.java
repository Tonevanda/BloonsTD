package game.Elements.Towers;

import base.model.game.Elements.Towers.BombTower;
import base.model.game.Elements.Towers.Towers;
import base.model.game.Elements.Towers.Upgrades;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BombTowerTest {
    @Test
    public void BombTower(){
        Towers bomb = new BombTower();
        assertEquals(45, bomb.getRadius());
        assertEquals(720, bomb.getValue());
    }
    @Test
    public void Price(){
        Towers bomb = new BombTower();
        assertEquals(900, bomb.price());
    }
    @Test
    public void upgradeLeft(){
        Towers bomb = new BombTower();
        Upgrades upgrade = new Upgrades();
        assertEquals(upgrade, bomb.getUpgrades());

        upgrade.upgradeLeft();
        assertNotEquals(upgrade, bomb.getUpgrades());
        assertTrue(bomb.upgradeLeft());
        assertEquals(upgrade, bomb.getUpgrades());
        assertEquals(1, bomb.getUpgrades().getLeft());
        assertEquals(720+520, bomb.getValue());

        assertFalse(bomb.upgradeLeft());
        upgrade.upgradeLeft();
        assertEquals(upgrade, bomb.getUpgrades());
        assertEquals(1, bomb.getUpgrades().getLeft());
        assertEquals(720+520, bomb.getValue());
    }
    @Test
    public void upgradeRight(){
        Towers bomb = new BombTower();
        Upgrades upgrade = new Upgrades();
        assertEquals(upgrade, bomb.getUpgrades());

        upgrade.upgradeRight();
        assertNotEquals(upgrade, bomb.getUpgrades());
        assertTrue(bomb.upgradeRight());
        assertEquals(upgrade, bomb.getUpgrades());
        assertEquals(1, bomb.getUpgrades().getRight());
        assertEquals(720+200, bomb.getValue());
        assertEquals(55, bomb.getRadius());

        assertFalse(bomb.upgradeRight());
        upgrade.upgradeRight();
        assertEquals(upgrade, bomb.getUpgrades());
        assertEquals(1, bomb.getUpgrades().getRight());
        assertEquals(720+200, bomb.getValue());
        assertEquals(55, bomb.getRadius());
    }
    @Test
    public void getFileName(){
        Towers bomb = new BombTower();
        assertEquals("monkey/BombTowerSprite", bomb.getFileName());
    }
    @Test
    public void getBuyFileName(){
        Towers bomb = new BombTower();
        assertEquals("menuBuy/MenuBomb", bomb.getBuyFileName());
    }

    @Test
    public void getUpgradePrice(){
        Towers bomb = new BombTower();
        assertEquals(750, bomb.getUpgradePrice('L'));
        assertEquals(350, bomb.getUpgradePrice('R'));
        assertEquals(0, bomb.getUpgradePrice('M'));
    }
    @Test
    public void canShootMultiple(){
        Towers bomb = new BombTower();
        assertFalse(bomb.canShootMultiple());
    }
}
