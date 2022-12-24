package base.game.Elements.Towers;

import base.model.game.Elements.Towers.DartMonkeyTower;
import base.model.game.Elements.Towers.Upgrades;
import base.model.game.Gameplay.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UpgradesTest {
    Upgrades up1;
    Upgrades up2;
    Upgrades up3;
    Upgrades up4;
    @BeforeEach
    void setUp(){
        up1 = new Upgrades();
        up2 = new Upgrades();
        up3 = new Upgrades();
        up4 = new Upgrades();
        up3.upgradeLeft();
        up4.upgradeRight();
    }
    @Test
    void Equals(){
        Position pos = Mockito.mock(Position.class);

        assertFalse(up1.equals(pos));
        assertTrue(up1.equals(up1));
        assertFalse(up1.equals(null));
        assertTrue(up1.equals(up2));
        assertFalse(up1.equals(up3));
        assertFalse(up4.equals(up3));
    }

    @Test
    void hasUpgraded(){
        assertFalse(up1.hasUpgraded('L'));
        assertFalse(up1.hasUpgraded('R'));
        assertTrue(up3.hasUpgraded('L'));
        assertTrue(up4.hasUpgraded('R'));
        assertFalse(up1.hasUpgraded('M'));
    }
}
