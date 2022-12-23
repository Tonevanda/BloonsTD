package base.ScreenLoader;

import base.ScreenLoader.Reader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ReaderTest {

    @Test
    public void Reader() {
        Reader reader = new Reader("DartMonkeyTowerSprite", 16, 16);
        assertNotNull(reader.getColor());
    }

}
