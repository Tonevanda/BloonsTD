package Monkey;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TowersTest {

    @Test
    public void Towers(){
        List<Towers> towers = new ArrayList<Towers>();
        Towers monkey = new DartMonkeyTower();
        towers.add(monkey);

    }
}
