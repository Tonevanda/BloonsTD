package Towers;

import base.Position;
import model.game.Elements.Towers.TackTower;
import model.game.Elements.Towers.Towers;
import model.game.Elements.Towers.Upgrades;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TackTowerTest {
    @Test
    public void TackTower(){
        Towers tack = new TackTower();
        assertEquals(80, tack.getRange());
        assertEquals(320, tack.getValue());
    }
    @Test
    public void Position(){
        Towers tack = new TackTower();

        Position position = new Position(1,1);
        tack.setPosition(position);
        assertEquals(position, tack.getPosition());

        position = new Position(300,150);
        assertNotEquals(position,tack.getPosition());

        tack.setPosition(position);
        assertEquals(position, tack.getPosition());
    }

    @Test
    public void Price(){
        Towers tack = new TackTower();
        assertEquals(400, tack.price());
    }

    @Test
    public void upgradeLeft(){
        Towers tack = new TackTower();
        Upgrades upgrade = new Upgrades();
        assertEquals(upgrade, tack.getUpgrades());

        upgrade.upgradeLeft();
        assertNotEquals(upgrade, tack.getUpgrades());
        assertTrue(tack.upgradeLeft());
        assertEquals(upgrade, tack.getUpgrades());
        assertEquals(320+200, tack.getValue());

        assertTrue(tack.upgradeLeft());
        upgrade.upgradeLeft();
        assertEquals(upgrade, tack.getUpgrades());
        assertEquals(320+200+270, tack.getValue());

        assertFalse(tack.upgradeLeft());
        assertEquals(upgrade, tack.getUpgrades());
        assertEquals(320+200+270, tack.getValue());
    }

    @Test
    public void upgradeRight(){
        Towers tack = new TackTower();
        Upgrades upgrade = new Upgrades();
        assertEquals(upgrade, tack.getUpgrades());

        upgrade.upgradeRight();
        assertNotEquals(upgrade, tack.getUpgrades());
        assertTrue(tack.upgradeRight());
        assertEquals(upgrade, tack.getUpgrades());
        assertEquals(320+120, tack.getValue());

        assertTrue(tack.upgradeRight());
        upgrade.upgradeRight();
        assertEquals(upgrade, tack.getUpgrades());
        assertEquals(320+120+160, tack.getValue());

        assertFalse(tack.upgradeRight());
        assertEquals(upgrade, tack.getUpgrades());
        assertEquals(320+120+160, tack.getValue());
    }
}
