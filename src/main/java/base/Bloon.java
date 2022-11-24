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
    private boolean hard = false;
    private Color[][] color = new Color[49][63];

    /*
     * 1: red
     * 2: blue
     * 3: green
     * 4: yellow
     * 5: pink
     * 6: hard
     */

    public Bloon(String color){
        coords = new Position(0,0);
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

    //concept
    public void move(){
        coords.setX(coords.getX() + 1);
        /*
        while(coords.getX() < 100 && coords.getY() < 50){
            coords.setX(coords.getX() + 1);
        }*/
    }

    public void draw(TextGraphics graphics, Screen screen) {
        URL resourceBloon = getClass().getResource("/bloons/" + getColorFile(layers) + ".png");
        BufferedImage bloonimg;
        try {
            bloonimg = ImageIO.read(resourceBloon);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }

        for(int i = 0;i<49;i++){
            for(int j = 0;j<63;j++){
                color[i][j] = new Color(bloonimg.getRGB(i,j));
            }
        }

        TextColor pixelColor;

        for(int i = 0;i<49;i++){
            for(int j = 0;j<63;j++){
                pixelColor = new TextColor.RGB(color[i][j].getRed(),color[i][j].getGreen(),color[i][j].getBlue());
                screen.setCharacter(coords.getX()+i,coords.getY()+j,new TextCharacter(' ').withBackgroundColor(pixelColor));

            }
        }
    }
}
