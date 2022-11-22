package base;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainMenu {
    private int width;
    private int height;
    private Play play;

    public MainMenu(int x, int y) {
        width = x;
        height = y;
    }
    public void StartGame(){
        play = new Play(width,height);
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width,height), ' ');

        /*
        try {
            BufferedImage image = ImageIO.read(getClass().getResource("/resources/hero.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }
}
