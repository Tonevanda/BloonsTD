package base.game.Gameplay;

import base.model.game.Elements.Towers.Tower;
import base.model.game.Gameplay.Play;
import base.model.game.Gameplay.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayTest {
    private Play play;

    @BeforeEach
    void setUp(){
        play = new Play();
    }

    @Test
    public void getRound() {
        assertEquals(1, play.getRound());
        play.nextRound();
        assertEquals(2, play.getRound());
    }

    @Test
    public void bloonSender() {
        assertEquals(10, play.getBloons().size());
        assertEquals(1, play.getBloons().get(0).getType());
        assertEquals(1, play.getRound());

        play.nextRound();
        assertEquals(25, play.getBloons().size());
        assertEquals(1, play.getBloons().get(11).getType());
        assertEquals(2, play.getBloons().get(24).getType());
        assertEquals(2, play.getRound());

        play.nextRound();
        assertEquals(35, play.getBloons().size());
        assertEquals(2, play.getBloons().get(26).getType());
        assertEquals(3, play.getRound());

        play.nextRound();
        assertEquals(50, play.getBloons().size());
        assertEquals(4, play.getRound());

        play.nextRound();
        assertEquals(65, play.getBloons().size());
        assertEquals(5, play.getRound());

        play.nextRound();
        assertEquals(90, play.getBloons().size());
        assertEquals(6, play.getRound());

        play.nextRound();
        assertEquals(100, play.getBloons().size());
        assertEquals(7, play.getRound());

        play.nextRound();
        assertEquals(120, play.getBloons().size());
        assertEquals(8, play.getRound());

        play.nextRound();
        assertEquals(135, play.getBloons().size());
        assertEquals(9, play.getRound());

        play.nextRound();
        assertEquals(165, play.getBloons().size());
        assertEquals(10, play.getRound());

        play.nextRound();
        assertEquals(180, play.getBloons().size());
        assertEquals(11, play.getRound());

        play.nextRound();
        assertEquals(200, play.getBloons().size());
        assertEquals(12, play.getRound());

        play.nextRound();
        assertEquals(220, play.getBloons().size());
        assertEquals(13, play.getRound());

        play.nextRound();
        assertEquals(225, play.getBloons().size());
        assertEquals(14, play.getRound());

        play.nextRound();
        assertEquals(255, play.getBloons().size());
        assertEquals(15, play.getRound());
    }

    @Test
    public void isAlive(){
        assertTrue(play.isAlive());
        play.getPlayer().loseLives(100);
        assertFalse(play.isAlive());
    }

    @Test
    public void setPlacingTower() {
        Tower tower = mock(Tower.class);
        play.setPlacingTower(tower);
        assertEquals(1, play.getPlacingTower().size());
        assertEquals(tower, play.getPlacingTower().get(0));

        play.stopPlacingTower();
        assertEquals(0, play.getPlacingTower().size());
    }

    @Test
    public void addGetandRemoveTowers() {
        Tower tower = mock(Tower.class);
        play.addTower(tower);

        assertEquals(1, play.getTowers().size());
        assertEquals(tower, play.getTowers().get(0));

        play.removeTower(tower);
        assertEquals(0, play.getTowers().size());

    }

    @Test
    public void popBloon() {
        Tower tower = mock(Tower.class);
        when(tower.getPoppingPower()).thenReturn(1);
        when(tower.getRadius()).thenReturn(1000);
        when(tower.getPosition()).thenReturn(new Position(50,50));
        when(tower.canShootMultiple()).thenReturn(Boolean.TRUE);
        when(tower.canShoot(0)).thenReturn(Boolean.TRUE);
        play.addTower(tower);

        assertEquals(10, play.getBloons().size());
        play.popBloon(0, 10);
        assertEquals(0, play.getBloons().size());
    }

}
