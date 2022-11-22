import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.run();
    }
}