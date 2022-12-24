package base.game.Elements.Towers;

import base.model.game.Elements.Towers.BombTower;
import base.model.game.Elements.Towers.Tower;
import base.model.game.Elements.Towers.Upgrades;
import base.model.game.Gameplay.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BombTowerTest {
    @Test
    public void BombTower(){
        Tower bomb = new BombTower();
        assertEquals(45, bomb.getRadius());
        assertEquals(720, bomb.getValue());

        bomb.setLastShot(2000);
        assertFalse(bomb.canShoot(3000));
        assertTrue(bomb.canShoot(11000));

        assertFalse(bomb.isSelected());
        assertEquals(90,bomb.getSize());
        bomb.select();
        assertTrue(bomb.isSelected());
        assertEquals(90,bomb.getSize());

        assertTrue(bomb.canPopHard());

        assertEquals(1,bomb.getPoppingPower());
    }
    @Test
    public void Price(){
        Tower bomb = new BombTower();
        assertEquals(900, bomb.price());
    }
    @Test
    public void upgradeLeft(){
        Tower bomb = new BombTower();
        Upgrades upgrade = new Upgrades();
        assertEquals(upgrade, bomb.getUpgrades());

        upgrade.upgradeLeft();
        assertNotEquals(upgrade, bomb.getUpgrades());
        assertTrue(bomb.upgradeLeft());
        assertEquals(upgrade, bomb.getUpgrades());
        assertEquals(1, bomb.getUpgrades().getLeft());
        assertEquals(2, bomb.getPoppingPower());
        assertEquals(720+520, bomb.getValue());

        assertFalse(bomb.upgradeLeft());
        upgrade.upgradeLeft();
        assertEquals(upgrade, bomb.getUpgrades());
        assertEquals(1, bomb.getUpgrades().getLeft());
        assertEquals(720+520, bomb.getValue());
    }
    @Test
    public void upgradeRight(){
        Tower bomb = new BombTower();
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
        Tower bomb = new BombTower();
        assertEquals("monkey/BombTowerSprite", bomb.getFileName());

        bomb.select();
        assertEquals("ranges/BombTowerBaseRange", bomb.getFileName());
    }
    @Test
    public void getBuyFileName(){
        Tower bomb = new BombTower();
        assertEquals("menuBuy/MenuBomb", bomb.getBuyFileName());
    }

    @Test
    public void getUpgradePrice(){
        Tower bomb = new BombTower();
        assertEquals(750, bomb.getUpgradePrice('L'));
        assertEquals(350, bomb.getUpgradePrice('R'));
        assertEquals(0, bomb.getUpgradePrice('M'));
    }
    @Test
    public void canShootMultiple(){
        Tower bomb = new BombTower();
        assertFalse(bomb.canShootMultiple());
    }
    @Test
    public void setPosition(){
        Tower bomb = new BombTower();
        bomb.setPosition(new Position(0,0));
        assertEquals(new Position(2,2),bomb.getPosition());
    }

}
