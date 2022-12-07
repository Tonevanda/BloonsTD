package Towers;

import base.Position;
import model.game.Elements.Towers.DartMonkeyTower;
import model.game.Elements.Towers.Upgrades;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DartMonkeyTowerTest {
    @Test
    public void DartMonkeyTower(){

        DartMonkeyTower monkey = new DartMonkeyTower();

        assertEquals(120, monkey.getRange());
        assertEquals(100, monkey.getValue());
    }

    @Test
    public void Position(){
        DartMonkeyTower monkey = new DartMonkeyTower();

        Position position = new Position(1,1);
        monkey.setPosition(position);
        assertEquals(position, monkey.getPosition());

        position = new Position(300,150);
        assertNotEquals(position,monkey.getPosition());

        monkey.setPosition(position);
        assertEquals(position, monkey.getPosition());
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
        assertEquals(268, monkey.getValue());

        assertTrue(monkey.upgradeLeft());
        upgrade.upgradeLeft();
        assertEquals(upgrade, monkey.getUpgrades());
        assertEquals(472, monkey.getValue());

        assertFalse(monkey.upgradeLeft());
        assertEquals(upgrade, monkey.getUpgrades());
        assertEquals(472, monkey.getValue());
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
        assertEquals(180, monkey.getValue());

        assertTrue(monkey.upgradeRight());
        upgrade.upgradeRight();
        assertEquals(upgrade, monkey.getUpgrades());
        assertEquals(270, monkey.getValue());

        assertFalse(monkey.upgradeRight());
        assertEquals(upgrade, monkey.getUpgrades());
        assertEquals(270, monkey.getValue());
    }

}
