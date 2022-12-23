package base.game.Gameplay;

import base.model.game.Gameplay.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp(){
        player = new Player();
    }

    @Test
    public void Player() {
        assertEquals(player.getMoney(), 500);
        assertEquals(player.getLives(), 100);
    }

    @Test
    public void canAfford() {
        assertTrue(player.canAfford(100));
        assertFalse(player.canAfford(1000));
        assertTrue(player.canAfford(500));
    }

    @Test
    public void addMoney() {
        player.addMoney(100);
        assertEquals(player.getMoney(), 600);
    }

    @Test
    public void spendMoney() {
        player.spendMoney(100);
        assertEquals(player.getMoney(), 400);
    }

    @Test
    public void loseHearts() {
        player.loseLives(2);
        assertEquals(player.getLives(), 98);
    }
}