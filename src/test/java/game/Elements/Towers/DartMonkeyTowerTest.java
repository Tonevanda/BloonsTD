package game.Elements.Towers;

import base.model.game.Elements.Towers.DartMonkeyTower;
import base.model.game.Elements.Towers.Upgrades;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DartMonkeyTowerTest {
    @Test
    public void DartMonkeyTower(){

        DartMonkeyTower monkey = new DartMonkeyTower();

        assertEquals(35, monkey.getRadius());

        assertEquals(100, monkey.getValue());

        monkey.setLastShot(2000);
        assertFalse(monkey.canShoot(3000));
        assertTrue(monkey.canShoot(7000));

        assertFalse(monkey.isSelected());
        assertEquals(70,monkey.getSize());
        monkey.select();
        assertTrue(monkey.isSelected());
        assertEquals(70,monkey.getSize());

        
    }

    @Test
    public void Position(){
        /*
        DartMonkeyTower monkey = new DartMonkeyTower();

        Position position = new Position(12,12);
        monkey.setPosition(position);
        System.out.println(monkey.getPosition().getX() + "," + monkey.getPosition().getY());
        System.out.println(position.getX() + "," + position.getY());
        assertEquals(position, monkey.getPosition());

        position = new Position(300,150);
        assertNotEquals(position,monkey.getPosition());

        monkey.setPosition(position);
        assertEquals(position, monkey.getPosition());

         */
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

        assertFalse(monkey.upgradeLeft());
        upgrade.upgradeLeft();
        assertEquals(upgrade, monkey.getUpgrades());
        assertEquals(268, monkey.getValue());
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

        assertFalse(monkey.upgradeRight());
        upgrade.upgradeRight();
        assertEquals(upgrade, monkey.getUpgrades());
        assertEquals(180, monkey.getValue());
    }

}
