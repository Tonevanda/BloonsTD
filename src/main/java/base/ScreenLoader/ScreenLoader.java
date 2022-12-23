package base.ScreenLoader;

import base.model.game.Elements.Bloon;
import base.model.game.Gameplay.Position;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import base.model.game.Elements.Towers.Tower;

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
    Integer pressedKey = -1;

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
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                mouseLocation = new Position(e.getX(), e.getY());
            }
        };

        ((AWTTerminalFrame)terminal).getComponent(0).addMouseListener(mouseAdapter);
        ((AWTTerminalFrame)terminal).getComponent(0).addMouseMotionListener(mouseAdapter);
        ((AWTTerminalFrame)terminal).getComponent(0).addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                pressedKey = e.getKeyCode();
            }
        });
        return terminal;
    }

    public void setMousePressed(Position pos){
        mousePressed = pos;
    }
    public Position getMousePressed(){
        Position pos = mousePressed;
        mousePressed = new Position(-1,-1);
        return pos;
    }

    public void setMouseLocation(Position pos){
        mouseLocation = pos;
    }
    public Position getMouseLocation(){
        return mouseLocation;
    }

    public void setPressedKey(int key){
        pressedKey = key;
    }
    public Integer getPressedKey(){
        Integer key = pressedKey;
        pressedKey = -1;
        return key;
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
        Reader arenaImg = new Reader("Play/newMap", 256,144);
        Color[][] color = arenaImg.getColor();
        Position pos = new Position(0,0);
        draw(256,144,pos, color);
    }
    public void drawTower(Tower tower){
        String file = tower.getFileName();
        Position centerPosition = new Position(tower.getPosition().getX()-(tower.getSize()/2), tower.getPosition().getY()- (tower.getSize()/2));
        Reader towerImg = new Reader(file, tower.getSize(), tower.getSize());
        Color[][] color = towerImg.getColor();
        draw(tower.getSize(),tower.getSize(),centerPosition, color);
    }
    public void drawBuyMenu(Tower tower){
        String file = tower.getBuyFileName();
        Reader img = new Reader(file, 57,74);
        Position position = new Position(195,65);
        Color[][] color = img.getColor();
        draw(57,74,position,color);

        Position rangePosition = new Position(238, 73);
        drawNumbers(tower.getRadius(), 2, rangePosition);
        Position sellPosition = new Position(240,130);
        drawNumbers(tower.getValue(), 4, sellPosition);
        Position upgradeLPosition = new Position(210,119);
        drawNumbers(tower.getUpgradePrice('L'), 3, upgradeLPosition);
        Position upgradeRPosition = new Position(240,119);
        drawNumbers(tower.getUpgradePrice('R'), 3, upgradeRPosition);

        file = "menuBuy/MaxedMenu";
        img = new Reader(file, 26,9);
        color = img.getColor();

        if(tower.upgrades.hasUpgraded('L')){
            position = new Position(196,118);
            draw(26,9,position,color);
        }
        if(tower.upgrades.hasUpgraded('R')){
            position = new Position(225,118);
            draw(26,9,position,color);
        }
    }

    public void drawBloon(Position pos, Bloon bloon){
        String file = bloon.getColorFile();
        Reader bloonImg = new Reader(file, 16, 16);
        Color[][] color = bloonImg.getColor();
        draw(16, 16, pos, color);
    }

    public void drawMenu(int width, int height){
        Reader menuImg = new Reader("mainMenu/logoStartButton", width, height);
        Color[][] color = menuImg.getColor();
        Position pos = new Position(0,0);
        draw(width, height, pos, color);
    }

    public void drawRound(int round){
        Position pos = new Position(247, 21);
        drawNumbers(round, 6, pos);
    }
    public void drawMoney(int money){
        Position pos = new Position(247, 27);
        drawNumbers(money, 6, pos);
    }
    public void drawLives(int lives){
        Position pos = new Position(247,33);
        drawNumbers(lives, 6, pos);
    }
    public void drawNumbers(int number, int size, Position position){
        for(int i = 0; i < size; i++){
            int n = number%10;
            number /= 10;
            Position numberPosition = new Position(position.getX()-4*i, position.getY());
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
