package base.game.Elements.Towers;

import base.model.game.Elements.Towers.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TowerTest {

    @Test
    public void Position(){
        List<Tower> towers = new ArrayList<>();
        Tower monkey = new DartMonkeyTower();
        towers.add(monkey);
        Tower tack = new TackTower();
        towers.add(tack);
        Tower bomb = new BombTower();
        towers.add(bomb);
        Tower ice = new IceTower();
        towers.add(ice);

        for(Tower tower : towers) {
            /*
            model.game.Gameplay.Position position = new Position(1, 1);
            tower.setPosition(position);
            assertEquals(position, tower.getPosition());

            position = new Position(300, 150);
            assertNotEquals(position, tower.getPosition());

            tower.setPosition(position);
            assertEquals(position, tower.getPosition());
            */
        }
    }
}
