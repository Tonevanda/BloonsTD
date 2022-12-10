package ScreenLoader;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;

public class ScreenLoader {
    private Screen screen;
    private Position mousePressed = new Position(-1,-1);

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

        ((AWTTerminalFrame)terminal).getComponent(0).addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mousePressed = new Position(e.getX(), e.getY());
                System.out.println("ScreenLoader: " + mousePressed.getX() + ", " + e.getY());
            }
        });
        return terminal;
    }
    public Position getMousePressed(){
        Position pos = mousePressed;
        mousePressed = new Position(-1,-1);
        return pos;
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

    public void drawTower(Position pos, Towers tower){
        String file = tower.getFileName();
        Reader towerImg = new Reader(file, 16, 16);
        Color[][] color = towerImg.getColor();
        draw(16,16,pos, color);
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
        /*Reader roundTxt = new Reader("roundTxt", 50,16); // a mudar ig
        Color[][] color = roundTxt.getColor();
        Position pos = new Position(200,10);
        draw(50,16,pos,color);*/

        Position numberPosition = new Position(200,10);
        drawNumber(numberPosition, round);
    }

    public void drawLives(int lives){
        /*Reader livesTxt = new Reader("livesTxt", 50,16); // a mudar ig
        Color[][] color = livesTxt.getColor();
        Position pos = new Position(200,20);
        draw(50,16,pos,color);*/

        int n1 = lives/100;
        int n2 = (lives/10)%10;
        int n3 = lives%10;
        Position numberPosition1 = new Position(200,20);
        Position numberPosition2 = new Position(209,20);
        Position numberPosition3 = new Position(218,20);
        drawNumber(numberPosition1, n1);
        drawNumber(numberPosition2, n2);
        drawNumber(numberPosition3, n3);
    }

    public void drawNumber(Position position, int number){
        Reader numberImg = new Reader("numbers/number"+number, 8,8);
        Color[][] color = numberImg.getColor();
        draw(8,8,position,color);
    }

    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
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
