package base.game.Elements.Towers;

import base.model.game.Elements.Towers.TackTower;
import base.model.game.Elements.Towers.Tower;
import base.model.game.Elements.Towers.Upgrades;
import base.model.game.Gameplay.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TackTowerTest {
    @Test
    public void TackTower() {
        Tower Tack = new TackTower();
        assertEquals(25, Tack.getRadius());
        assertEquals(320, Tack.getValue());
        Tack.setLastShot(2000);
        assertFalse(Tack.canShoot(6000));
        assertTrue(Tack.canShoot(8000));
        assertFalse(Tack.isSelected());
        assertEquals(50, Tack.getSize());
        Tack.select();
        assertTrue(Tack.isSelected());
        assertEquals(50, Tack.getSize());
        assertFalse(Tack.canPopHard());
        assertEquals(1, Tack.getPoppingPower());
    }
    @Test
    public void Price(){
        Tower Tack = new TackTower();
        assertEquals(400, Tack.price());
    }

    @Test
    public void upgradeLeft(){
        Tower Tack = new TackTower();
        Upgrades upgrade = new Upgrades();
        assertEquals(upgrade, Tack.getUpgrades());

        upgrade.upgradeLeft();
        assertNotEquals(upgrade, Tack.getUpgrades());
        assertTrue(Tack.upgradeLeft());
        assertEquals(upgrade, Tack.getUpgrades());
        Tack.setLastShot(2000);
        assertFalse(Tack.canShoot(4000)); //here
        assertTrue(Tack.canShoot(6000));
        assertEquals(320+100, Tack.getValue());

        assertFalse(Tack.upgradeLeft());
        upgrade.upgradeLeft();
        assertEquals(upgrade, Tack.getUpgrades());
        assertFalse(Tack.canShoot(4000));
        assertTrue(Tack.canShoot(6000));
        assertEquals(320+100, Tack.getValue());
    }

    @Test
    public void upgradeRight(){
        Tower Tack = new TackTower();
        Upgrades upgrade = new Upgrades();
        assertEquals(upgrade, Tack.getUpgrades());

        upgrade.upgradeRight();
        assertNotEquals(upgrade, Tack.getUpgrades());
        assertTrue(Tack.upgradeRight());
        assertEquals(upgrade, Tack.getUpgrades());
        assertEquals(80, Tack.getSize());
        assertEquals(40, Tack.getRadius()); //aqui
        assertEquals(320+120, Tack.getValue());
        assertFalse(Tack.upgradeRight());
        upgrade.upgradeRight();
        assertEquals(upgrade, Tack.getUpgrades());
        assertEquals(80, Tack.getSize());
        assertEquals(40, Tack.getRadius());
        assertEquals(320+120, Tack.getValue());
    }
    @Test
    public void getFileName(){
        Tower Tack = new TackTower();
        assertEquals("monkey/TackTowerSprite", Tack.getFileName());

        Tack.select();
        assertEquals("ranges/TackTowerBaseRange", Tack.getFileName());
    }
    @Test
    public void getBuyFileName(){
        Tower Tack = new TackTower();
        assertEquals("menuBuy/MenuTack", Tack.getBuyFileName());
    }

    @Test
    public void getUpgradePrice(){
        Tower Tack = new TackTower();
        assertEquals(300, Tack.getUpgradePrice('L'));
        assertEquals(200, Tack.getUpgradePrice('R'));
        assertEquals(0, Tack.getUpgradePrice('M'));
    }
    @Test
    public void canShootMultiple(){
        Tower Tack = new TackTower();
        assertTrue(Tack.canShootMultiple());
    }
    @Test
    public void setPosition(){
        Tower Tack = new TackTower();
        Tack.setPosition(new Position(0,0));
        assertEquals(new Position(2,2),Tack.getPosition());
    }
}
