package base;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Game {
    private Screen screen;
    private MainMenu mainmenu;
    //private Arena arena;

    public Game(){
        try {
            TerminalSize terminalSize = new TerminalSize(190, 50);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize).setForceAWTOverSwing(true);;
            Terminal terminal = terminalFactory.createTerminal();
            MouseAdapter mouseAdapter=new MouseAdapter() {
                private Color background;

                @Override
                public void mousePressed(MouseEvent e) {
                    //System.out.println(e.getXOnScreen());
                    System.out.println(e.getX());
                    TextGraphics graphics=screen.newTextGraphics();
                    try {
                        screen.clear();
                        graphics.setBackgroundColor(TextColor.Factory.fromString("#330000"));
                        graphics.fillRectangle(new TerminalPosition(e.getX(), e.getY()), new TerminalSize(30,30), ' ');
                        screen.refresh();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    //System.out.println("deez");
                    //repaint();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    //background = Color.black;
                }
            };
            ((AWTTerminalFrame)terminal).getComponent(0).addMouseListener(mouseAdapter);
            //((AWTTerminalFrame)terminal).getComponent(0).addMouseMotionListener(mouseAdapter);
            this.screen = new TerminalScreen(terminal);
            this.screen.setCursorPosition(null);
            this.screen.startScreen();
            this.screen.doResizeIfNecessary();
            mainmenu = new MainMenu(190, 50);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void draw() throws IOException {

        mainmenu.draw(screen.newTextGraphics());
        this.screen.refresh();
    }
    public void run() throws IOException {
        this.screen.clear();
        while(true) {
            draw();
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
