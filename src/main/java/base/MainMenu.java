package base;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class MainMenu  {
    private int width;
    private int height;
    private Play play;
    private Color[][] macaco = new Color[256][144];

    public MainMenu(int x, int y) {
        width = x;
        height = y;
    }

    public void StartGame(){
        play = new Play(width,height);
    }

    public void draw(TextGraphics graphics, Screen screen) {
        //Reader reader = new Reader("/monkey/16", 16, 16);

        URL resourcemancaco = getClass().getResource("/monkey/logo.png");
        BufferedImage mancaco;
        try {
            mancaco = ImageIO.read(resourcemancaco);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(int i = 0;i<256;i++){
            for(int j = 0;j<144;j++){
                macaco[i][j] = new Color(mancaco.getRGB(i,j));
            }
        }

        TextColor pixelColor;

        for (int i=0;i<256;i++){
            for(int j=0;j<144;j++){
                pixelColor = new TextColor.RGB(macaco[i][j].getRed(),macaco[i][j].getGreen(),macaco[i][j].getBlue());
                screen.setCharacter(i,j,new TextCharacter(' ').withBackgroundColor(pixelColor));
            }
        }
        graphics.setBackgroundColor(TextColor.Factory.fromString("#0000FF"));
        graphics.fillRectangle(new TerminalPosition(128, 72), new TerminalSize(50,30), ' ');

        //new Panel();
        /*
        graphics.setBackgroundColor(TextColor.Factory.fromString("#0000FF"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width,height), ' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.fillRectangle(new TerminalPosition(50, 30), new TerminalSize(30,30), ' ');

 */


    }
}
