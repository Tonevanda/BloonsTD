package base;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import javax.swing.event.MouseInputAdapter;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Game {
    private Screen screen;
    private MainMenu mainmenu;
    private Play play;
    private boolean isPlaying = false;
    //private Arena arena;

    public Game(){
        try {
            URL resource = getClass().getClassLoader().getResource("square.ttf");
            File fontFile = new File(resource.toURI());
            Font font =  Font.createFont(Font.TRUETYPE_FONT, fontFile);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);

            DefaultTerminalFactory factory = new DefaultTerminalFactory();

            Font loadedFont = font.deriveFont(Font.PLAIN, 4);
            AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
            factory.setTerminalEmulatorFontConfiguration(fontConfig);
            factory.setForceAWTOverSwing(true);
            factory.setInitialTerminalSize(new TerminalSize(256, 144));

            Terminal terminal = factory.createTerminal();
            ((AWTTerminalFrame)terminal).addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    e.getWindow().dispose();
                }
            });
            MouseAdapter mouseAdapter = new MouseAdapter(){

                private Color background;
                @Override
                public void mousePressed(MouseEvent e){
                    System.out.println(e.getX());
                    TextGraphics graphics=screen.newTextGraphics();
                    if(e.getX()>103*4 && e.getX()<153*4 && e.getY()>72*4 && e.getY()<102*4){
                        play = new Play(256,144);
                        isPlaying = true;
                        screen.clear();

                        play.draw(graphics, screen);
                        try {
                            screen.refresh();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        play.startGame();
                    }

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e){
                    //System.out.println("idk");
                }
                @Override
                public void mouseDragged(MouseEvent e){
                }

                //MouseEvent test=new MouseEvent("mouseonbutton", {"clientX":10, "clientY":10}); Teste que não funcionou DO NOT DELETE
            };

            ((AWTTerminalFrame)terminal).getComponent(0).addMouseListener(mouseAdapter);
            //((AWTTerminalFrame)terminal).getComponent(0).addMouseMotionListener(mouseAdapter);
            this.screen = new TerminalScreen(terminal);
            this.screen.setCursorPosition(null);
            this.screen.startScreen();
            this.screen.doResizeIfNecessary();
            mainmenu = new MainMenu(256, 144);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        }
    }

    private void draw() throws IOException {
        this.screen.clear();
        if(!isPlaying)mainmenu.draw(screen.newTextGraphics(),screen);
        this.screen.refresh();
    }

    public void run() throws IOException {
        draw();
        while(true) {
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.EOF)
                break;
            if (!play.isAlive()){
                isPlaying=false;
                draw();
            }
            /*
            KeyStroke key = screen.readInput();
            processKey(key);
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == ('q'))
                screen.close();
            if (key.getKeyType() == KeyType.EOF)
                break;
            if(arena.verifyMonsterCollisions()){
                System.out.println("May you REST IN (ONE) PIECE");
                screen.close();
            }*/
        }
    }
    /*
    private void processKey(KeyStroke key) throws IOException{
        arena.processKey(key);
    }
    */
}
