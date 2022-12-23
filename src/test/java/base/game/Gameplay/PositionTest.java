package base.game.Gameplay;
import base.model.game.Gameplay.Position;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import base.model.game.Elements.Towers.Tower;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    public void isBetween() {
        Position pos1 = new Position(0, 0);
        Position pos2 = new Position(5, 5);
        Position pos3 = new Position(2, 2);
        Position pos4 = new Position(6, 6);
        Position pos5 = new Position(6,6);
        Position pos6 = new Position(6,6);
        assertTrue(pos3.isBetween(pos1, pos2));
        assertFalse(pos4.isBetween(pos1, pos2));
        assertTrue(pos5.isBetween(pos4, pos1));
        assertTrue(pos6.isBetween(pos4,pos5));
    }

    @Test
    public void legalPosition() {
        List<Tower> towers = new ArrayList<>();
        Position mousePos = new Position(100, 100);
        towers.add(mock(Tower.class));
        when(towers.get(0).getPosition()).thenReturn(mousePos);

        Position pos2 = new Position(408, 408);
        assertFalse(pos2.legalPosition(towers));
        Position pos3 = new Position(1, 1);
        assertTrue(pos3.legalPosition(towers));
    }

    @Test
    public void isInRange() {
        Position pos1 = new Position(10, 10);
        Position pos2 = new Position(20, 20);
        assertTrue(pos2.isInRange(pos1, 30));
        assertFalse(pos2.isInRange(pos1, 2));
    }

    @Test
    void Equals(){
        Position pos1 = new Position(10,10);
        Position pos2 = new Position(20, 20);
        Position pos3 = new Position(20, 20);

        assertTrue(pos2.equals(pos3));
        assertFalse(pos1.equals(pos2));
    }
}
