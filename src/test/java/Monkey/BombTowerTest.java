package Monkey;

import com.Tiago27Cruz.hero.Towers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BombTowerTest {
    @Test
    public void BombTower(){
        Towers bomb = new BombTower();
        assertEquals(200, bomb.getRange());
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
        assertEquals(720+520, bomb.getValue());

        assertTrue(bomb.upgradeLeft());
        upgrade.upgradeLeft();
        assertEquals(upgrade, bomb.getUpgrades());
        assertEquals(720+520+640, bomb.getValue());

        assertFalse(bomb.upgradeLeft());
        assertEquals(upgrade, bomb.getUpgrades());
        assertEquals(720+520+640, bomb.getValue());
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
        assertEquals(720+200, bomb.getValue());

        assertTrue(bomb.upgradeRight());
        upgrade.upgradeRight();
        assertEquals(upgrade, bomb.getUpgrades());
        assertEquals(720+200+300, bomb.getValue());

        assertFalse(bomb.upgradeRight());
        assertEquals(upgrade, bomb.getUpgrades());
        assertEquals(720+200+300, bomb.getValue());
    }
}
