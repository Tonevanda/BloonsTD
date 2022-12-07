package model.game.Elements;

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
import java.util.concurrent.TimeUnit;

public class Bloon{
    private Position position;
    private int layers;
    private int type;
    private boolean hard = false;
    /*
     * 1: red
     * 2: blue
     * 3: green
     * 4: yellow
     * 5: pink
     * 6: hard
     */

    public Bloon(String color){
        position = new Position(0,0);
        switch(color){
            case "red": layers = 1; type =1; break;
            case "blue": layers = 2; type = 2; break;
            case "green": layers = 3; type = 3; break;
            case "yellow": layers = 4; type = 4; break;
            case "pink": layers = 5; type = 5; break;
            case "hard": layers = 6; type = 6; hard = true; break;
        }
    }

    public void setPosition(Position newPos){
        position = newPos;
    }

    public Position getPosition(){
        return position;
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

    public String getColorFile(){
        switch(layers){
            case 1: return "bloons/redBloonPixel";
            case 2: return "blueBloon";
            case 3: return "greenBloon";
            case 4: return "yellowBloon";
            case 5: return "pinkBloon";
            case 6: return "hardBloon";
            default: return "";
        }
    }
}
