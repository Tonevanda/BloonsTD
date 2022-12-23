package base.game.Elements;

import base.model.game.Elements.Bloon;
import base.model.game.Elements.Towers.Towers;
import base.model.game.Gameplay.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BloonTest {
    @Test
    public void Bloon() {
        Bloon redBloon = new Bloon("red");
        assertEquals(redBloon.getLayers(), 1);
        assertEquals(redBloon.getType(), 1);
        assertFalse(redBloon.isHard());

        Bloon blueBloon = new Bloon("blue");
        assertEquals(blueBloon.getLayers(), 2);
        assertEquals(blueBloon.getType(), 2);
        assertFalse(blueBloon.isHard());

        Bloon greenBloon = new Bloon("green");
        assertEquals(greenBloon.getLayers(), 3);
        assertEquals(greenBloon.getType(), 3);
        assertFalse(greenBloon.isHard());

        Bloon yellowBloon = new Bloon("yellow");
        assertEquals(yellowBloon.getLayers(), 4);
        assertEquals(yellowBloon.getType(), 4);
        assertFalse(yellowBloon.isHard());

        Bloon pinkBloon = new Bloon("pink");
        assertEquals(pinkBloon.getLayers(), 5);
        assertEquals(pinkBloon.getType(), 5);
        assertFalse(pinkBloon.isHard());

        Bloon hardBloon = new Bloon("hard");
        assertEquals(hardBloon.getLayers(), 6);
        assertEquals(hardBloon.getType(), 6);
        assertTrue(hardBloon.isHard());
    }

    @Test
    public void Position() {
        Bloon bloon = new Bloon("red");
        Position initialPosition = bloon.getPosition();
        assertEquals(initialPosition.getX(), -30);
        assertEquals(initialPosition.getY(), 48);

        Position newPos = new Position(10, 20);
        bloon.setPosition(newPos);
        assertEquals(bloon.getPosition(), newPos);
    }

    @Test
    public void PopBloon() {
        Bloon bloon = new Bloon("red");
        Towers tower = mock(Towers.class);
        when(tower.getPoppingPower()).thenReturn(1);
        when(tower.canPopHard()).thenReturn(true);

        bloon.pop(tower);
        assertEquals(bloon.getLayers(), 0);

        bloon = new Bloon("blue");
        bloon.pop(tower);
        assertEquals(bloon.getLayers(), 1);

        bloon = new Bloon("hard");
        bloon.pop(tower);
        assertFalse(bloon.isHard());
        assertEquals(bloon.getLayers(), 5);

        verify(tower, times(2)).getPoppingPower();
        verify(tower).canPopHard();
    }
}