package base.game.Gameplay;

import base.model.game.Elements.Towers.Towers;
import base.model.game.Gameplay.Play;
import base.model.game.Gameplay.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        play.nextRound();
        assertEquals(25, play.getBloons().size());
        assertEquals(1, play.getBloons().get(11).getType());
        assertEquals(2, play.getBloons().get(24).getType());

        play.nextRound();
        assertEquals(35, play.getBloons().size());
        assertEquals(2, play.getBloons().get(26).getType());
    }

    @Test
    public void setPlacingTower() {
        Towers tower = mock(Towers.class);
        play.setPlacingTower(tower);
        assertEquals(1, play.getPlacingTower().size());
        assertEquals(tower, play.getPlacingTower().get(0));

        play.stopPlacingTower();
        assertEquals(0, play.getPlacingTower().size());
    }

    @Test
    public void addGetandRemoveTowers() {
        Towers tower = mock(Towers.class);
        play.addTower(tower);

        assertEquals(1, play.getTowers().size());
        assertEquals(tower, play.getTowers().get(0));

        play.removeTower(tower);
        assertEquals(0, play.getTowers().size());

    }

    @Test
    public void popBloon() {
        Towers tower = mock(Towers.class);
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
