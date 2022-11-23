package base;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import javax.imageio.ImageIO;
import java.awt.*;
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

    public void draw(TextGraphics graphics) throws IOException {
            Reader image = new Reader("monkey/Dart_Monkey_Icon");



/*
        graphics.setBackgroundColor(TextColor.Factory.fromString("#0000FF"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width,height), ' ');
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.fillRectangle(new TerminalPosition(50, 30), new TerminalSize(30,30), ' ');

 */


    }
}
