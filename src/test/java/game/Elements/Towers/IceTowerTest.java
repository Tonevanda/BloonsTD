package game.Elements.Towers;

import base.model.game.Elements.Towers.IceTower;
import base.model.game.Elements.Towers.TackTower;
import base.model.game.Elements.Towers.Towers;
import base.model.game.Elements.Towers.Upgrades;
import base.model.game.Gameplay.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IceTowerTest {
    @Test
    public void IceTower(){
        Towers ice = new IceTower();
        assertEquals(30, ice.getRadius());
        assertEquals(400, ice.getValue());

        ice.setLastShot(2000);
        assertFalse(ice.canShoot(3000));
        assertTrue(ice.canShoot(10000));

        assertFalse(ice.isSelected());
        assertEquals(60,ice.getSize());
        ice.select();
        assertTrue(ice.isSelected());
        assertEquals(60,ice.getSize());

        assertFalse(ice.canPopHard());

        assertEquals(2,ice.getPoppingPower());
    }
    @Test
    public void Price(){
        Towers ice = new IceTower();
        assertEquals(650, ice.price());
    }
    @Test
    public void upgradeLeft(){
        Towers ice = new IceTower();
        Upgrades upgrade = new Upgrades();
        assertEquals(upgrade, ice.getUpgrades());

        upgrade.upgradeLeft();
        assertNotEquals(upgrade, ice.getUpgrades());
        assertTrue(ice.upgradeLeft());
        assertEquals(upgrade, ice.getUpgrades());
        assertEquals(400+360, ice.getValue());
        assertTrue(ice.canPopHard());

        assertFalse(ice.upgradeLeft());
        upgrade.upgradeLeft();
        assertEquals(upgrade, ice.getUpgrades());
        assertEquals(400+360, ice.getValue());
        assertTrue(ice.canPopHard());
    }
    @Test
    public void upgradeRight(){
        Towers ice = new IceTower();
        Upgrades upgrade = new Upgrades();
        assertEquals(upgrade, ice.getUpgrades());

        upgrade.upgradeRight();
        assertNotEquals(upgrade, ice.getUpgrades());
        assertTrue(ice.upgradeRight());
        assertEquals(upgrade, ice.getUpgrades());
        assertEquals(30+15,ice.getRadius());
        assertEquals(400+240, ice.getValue());
        assertEquals(70,ice.getSize());

        assertFalse(ice.upgradeRight());
        upgrade.upgradeRight();
        assertEquals(upgrade, ice.getUpgrades());
        assertEquals(30+15,ice.getRadius());
        assertEquals(400+240, ice.getValue());
        assertEquals(70,ice.getSize());
    }
    @Test
    public void getFileName(){
        Towers ice = new IceTower();
        assertEquals("monkey/IceTowerSprite", ice.getFileName());
    }
    @Test
    public void getBuyFileName(){
        Towers ice = new IceTower();
        assertEquals("menuBuy/MenuIce", ice.getBuyFileName());
    }

    @Test
    public void getUpgradePrice(){
        Towers ice = new IceTower();
        assertEquals(500, ice.getUpgradePrice('L'));
        assertEquals(350, ice.getUpgradePrice('R'));
        assertEquals(0, ice.getUpgradePrice('M'));
    }
    @Test
    public void canShootMultiple(){
        Towers ice = new IceTower();
        assertTrue(ice.canShootMultiple());
    }
    @Test
    public void setPosition(){
        Towers ice = new IceTower();
        ice.setPosition(new Position(0,0));
        assertEquals(new Position(2,2),ice.getPosition());
    }
}
