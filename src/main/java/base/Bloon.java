package base;

import base.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Bloon{
    private Position coords;
    private int layers;
    private int type;
    private boolean hard;
    private Color[][] color = new Color[16][16];

    /*
     * 1: red
     * 2: blue
     * 3: green
     * 4: yellow
     * 5: pink
     * 6: hard
     */

    public Bloon(String color){
        switch(color){
            case "red": layers = 1; type =1; break;
            case "blue": layers = 2; type = 2; break;
            case "green": layers = 3; type = 3; break;
            case "yellow": layers = 4; type = 4; break;
            case "pink": layers = 5; type = 5; break;
            case "hard": layers = 6; type = 6; hard = true; break;
        }
    }

    public Position getCoords(){
        return coords;
    }
    public int getLayers(){
        return layers;
    }

    public int getType(){
        return type;
    }

    public void pop(){
        layers--;
    }

    public String getColorFile(int layer){
        switch(layer){
            case 1: return "redBloon";
            case 2: return "blueBloon";
            case 3: return "greenBloon";
            case 4: return "yellowBloon";
            case 5: return "pinkBloon";
            case 6: return "hardBloon";
            default: return "";
        }
    }

    public void draw(TextGraphics graphics, Screen screen) {
        URL resourceBloon = getClass().getResource("/bloons/" + getColorFile(layers) + ".png");
        BufferedImage bloon;
        try {
            bloon = ImageIO.read(resourceBloon);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(int i = 0;i<16;i++){
            for(int j = 0;j<16;j++){
                color[i][j] = new Color(bloon.getRGB(i,j));
            }
        }

        TextColor pixelColor;

        for (int i=0;i<256;i++){
            for(int j=0;j<144;j++){
                pixelColor = new TextColor.RGB(color[i][j].getRed(),color[i][j].getGreen(),color[i][j].getBlue());
                screen.setCharacter(i,j,new TextCharacter(' ').withBackgroundColor(pixelColor));
            }
        }
    }
}
