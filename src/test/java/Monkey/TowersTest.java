package Monkey;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TowersTest {

    @Test
    public void Towers(){
        List<Towers> towers = new ArrayList<>();
        Towers monkey = new DartMonkeyTower();
        towers.add(monkey);
        Towers tack = new TackTower();
        towers.add(tack);
        Towers bomb = new BombTower();
        towers.add(bomb);
        Towers ice = new IceTower();
        towers.add(ice);
    }
}
