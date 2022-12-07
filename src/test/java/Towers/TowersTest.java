package Towers;

import base.Position;
import model.game.Elements.Towers.*;
import model.game.Towers.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TowersTest {

    @Test
    public void Position(){
        List<Towers> towers = new ArrayList<>();
        Towers monkey = new DartMonkeyTower();
        towers.add(monkey);
        Towers tack = new TackTower();
        towers.add(tack);
        Towers bomb = new BombTower();
        towers.add(bomb);
        Towers ice = new IceTower();
        towers.add(ice);

        for(Towers tower : towers) {
            base.Position position = new Position(1, 1);
            tower.setPosition(position);
            assertEquals(position, tower.getPosition());

            position = new Position(300, 150);
            assertNotEquals(position, tower.getPosition());

            tower.setPosition(position);
            assertEquals(position, tower.getPosition());
        }
    }
}
