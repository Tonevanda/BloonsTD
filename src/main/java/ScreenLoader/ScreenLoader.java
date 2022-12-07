package ScreenLoader;

import model.game.Elements.Bloon;
import base.Position;
import base.Reader;
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
                System.out.println("ScreenLoader: " + mousePressed.getX() + ", " + mousePressed.getY());
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
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        DefaultTerminalFactory factory = new DefaultTerminalFactory();

        Font loadedFont = font.deriveFont(Font.PLAIN, 4);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
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
        Reader arenaImg = new Reader("map", 256,144);
        Color[][] color = arenaImg.getColor();
        Position pos = new Position(0,0);
        draw(256,144,pos, color);
    }

    public void drawTower(Position pos, Towers tower){
        String file = tower.getFileName();
        Reader towerImg = new Reader(file, 69, 69); // alterar para actual size qnd tivermos os macaquitos
        Color[][] color = towerImg.getColor();
        draw(69,69,pos, color);
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
