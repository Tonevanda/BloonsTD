package ScreenLoader;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.game.Elements.Bloon;
import base.Position;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import model.game.Elements.Towers.Towers;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ScreenLoader{
    private Screen screen;
    private Position mousePressed = new Position(-1,-1);
    private Position mouseLocation = new Position(-1,-1);

    public ScreenLoader(Screen screen){
        this.screen = screen;
    }
    public ScreenLoader(int width, int height) throws IOException, URISyntaxException, FontFormatException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width,int height, AWTTerminalFontConfiguration fontConfig) throws IOException{
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        ((AWTTerminalFrame)terminal).addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
            }
        });
        MouseAdapter mouseAdapter = new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                mousePressed = new Position(e.getX(), e.getY());
                System.out.println("mousePressed: " + mousePressed.getX()/4 + ", " + mousePressed.getY()/4);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                mouseLocation = new Position(e.getX(), e.getY());
            }
        };

        ((AWTTerminalFrame)terminal).getComponent(0).addMouseListener(mouseAdapter);
        ((AWTTerminalFrame)terminal).getComponent(0).addMouseMotionListener(mouseAdapter);
        return terminal;
    }

    public Position getMousePressed(){
        Position pos = mousePressed;
        mousePressed = new Position(-1,-1);
        return pos;
    }

    public Position getMouseLocation(){
        return mouseLocation;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws IOException, FontFormatException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource("square.ttf");
        assert resource != null;
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        //DefaultTerminalFactory factory = new DefaultTerminalFactory();

        Font loadedFont = font.deriveFont(Font.PLAIN, 4);
        return AWTTerminalFontConfiguration.newInstance(loadedFont);
    }

    public void draw(int width, int height, Position pos, Color[][] color){
        TextColor pixelColor;
        for (int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                pixelColor = new TextColor.RGB(color[i][j].getRed(),color[i][j].getGreen(),color[i][j].getBlue());

                if(!(pixelColor.getRed()==200 && pixelColor.getGreen()==191 && pixelColor.getBlue()==231)) {
                    screen.setCharacter(i + pos.getX(), j + pos.getY(), new TextCharacter(' ').withBackgroundColor(pixelColor));
                }
            }
        }
    }

    public void drawArena(){
        Reader arenaImg = new Reader("newMap", 256,144);
        Color[][] color = arenaImg.getColor();
        Position pos = new Position(0,0);
        draw(256,144,pos, color);
    }

    public void drawTower(Towers tower){
        String file = tower.getFileName();
        Reader towerImg = new Reader(file, 16, 16);
        Color[][] color = towerImg.getColor();
        draw(16,16,tower.getPosition(), color);
    }

    public void drawBloon(Position pos, Bloon bloon){
        String file = bloon.getColorFile();
        Reader bloonImg = new Reader(file, 16, 16);
        Color[][] color = bloonImg.getColor();
        draw(16, 16, pos, color);
    }

    public void drawMenu(int width, int height){
        Reader menuImg = new Reader("monkey/logoStartButton", width, height);
        Color[][] color = menuImg.getColor();
        Position pos = new Position(0,0);
        draw(width, height, pos, color);
    }

    //conceptual
    public void drawRound(int round){
        for(int i = 0; i < 6; i++){
            int n = round%10;
            round /= 10;
            Position numberPosition = new Position(247 - 4*i, 21);
            drawNumber(numberPosition, n);
        }
    }
    public void drawMoney(int money){
        for(int i = 0; i < 6; i++){
            int n = money%10;
            money /= 10;
            Position numberPosition = new Position(247 - 4*i, 27);
            drawNumber(numberPosition, n);
        }
    }

    public void drawLives(int lives){
        for(int i = 0; i < 6; i++){
            int n = lives%10;
            lives /= 10;
            Position numberPosition = new Position(247 - 4*i, 33);
            drawNumber(numberPosition, n);
        }
    }



    public void drawNumber(Position position, int number){
        Reader numberImg = new Reader("numbers/"+number, 5,7);
        Color[][] color = numberImg.getColor();
        draw(5,7,position,color);
    }

    public void clear() {
        screen.clear();
    }

    public void refresh() throws IOException {
        screen.refresh();
    }

    public void close() throws IOException {
        screen.close();
    }

    public Screen getScreen() {
        return screen;
    }
}
