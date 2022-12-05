package Towers;

import model.game.Towers.IceTower;
import model.game.Towers.Towers;
import model.game.Towers.Upgrades;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IceTowerTest {
    @Test
    public void IceTower(){
        Towers bomb = new IceTower();
        assertEquals(100, bomb.getRange());
        assertEquals(680, bomb.getValue());
    }
    @Test
    public void Price(){
        Towers bomb = new IceTower();
        assertEquals(850, bomb.price());
    }
    @Test
    public void upgradeLeft(){
        Towers bomb = new IceTower();
        Upgrades upgrade = new Upgrades();
        assertEquals(upgrade, bomb.getUpgrades());

        upgrade.upgradeLeft();
        assertNotEquals(upgrade, bomb.getUpgrades());
        assertTrue(bomb.upgradeLeft());
        assertEquals(upgrade, bomb.getUpgrades());
        assertEquals(680+360, bomb.getValue());

        assertTrue(bomb.upgradeLeft());
        upgrade.upgradeLeft();
        assertEquals(upgrade, bomb.getUpgrades());
        assertEquals(680+360+400, bomb.getValue());

        assertFalse(bomb.upgradeLeft());
        assertEquals(upgrade, bomb.getUpgrades());
        assertEquals(680+360+400, bomb.getValue());
    }
    @Test
    public void upgradeRight(){
        Towers bomb = new IceTower();
        Upgrades upgrade = new Upgrades();
        assertEquals(upgrade, bomb.getUpgrades());

        upgrade.upgradeRight();
        assertNotEquals(upgrade, bomb.getUpgrades());
        assertTrue(bomb.upgradeRight());
        assertEquals(upgrade, bomb.getUpgrades());
        assertEquals(680+240, bomb.getValue());

        assertTrue(bomb.upgradeRight());
        upgrade.upgradeRight();
        assertEquals(upgrade, bomb.getUpgrades());
        assertEquals(680+240+280, bomb.getValue());

        assertFalse(bomb.upgradeRight());
        assertEquals(upgrade, bomb.getUpgrades());
        assertEquals(680+240+280, bomb.getValue());
    }
}
