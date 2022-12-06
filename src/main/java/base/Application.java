package base;

import ScreenLoader.ScreenLoader;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import menu.Menu;
import states.MainMenuState;
import states.State;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Application {
    private ScreenLoader screen;
    private State state;

    public Application() throws IOException, URISyntaxException, FontFormatException {
        this.screen = new ScreenLoader(256,144);
        this.state = new MainMenuState(new Menu(),screen);
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        //Game game = new Game();
        //game.run();
        new Application().start() ;
    }

    public void setState(State state) {this.state = state;}

    public void start() {
        int FPS = 10;
        int frameTime = 1000 / FPS;
        state.draw();

        while (this.state != null) {
            long startTime = System.currentTimeMillis();
            state.step(this, screen, startTime);
            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;
            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
    }
}