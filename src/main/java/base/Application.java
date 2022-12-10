package base;

import ScreenLoader.ScreenLoader;
import model.menu.Menu;
import states.MainMenuState;
import states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    private ScreenLoader screen;
    private State state;

    public Application() throws IOException, URISyntaxException, FontFormatException {
        this.screen = new ScreenLoader(256,144);
        this.state = new MainMenuState(new Menu());
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        new Application().start() ;
    }

    public void setState(State state) {this.state = state;}

    public void start() throws IOException {
        int FPS = 30;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, screen, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime);
                    //System.out.println("Thread is slept");
                }
            } catch (InterruptedException e) {
                //System.out.println("Interrupted Exception??whatever that is");
            }
        }
        screen.close();
    }
}