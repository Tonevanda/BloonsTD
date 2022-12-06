package base;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

public class Reader {
    private int x;
    private int y;
    private Color[][] color;
    private BufferedImage image;

    public Reader(String file,int x, int y){
        this.x = x;
        this.y = y;
        this.color=new Color[x][y];
        this.color = imgGetter(file);
        /* pixelColor;
        for (int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                pixelColor = new TextColor.RGB(color[i][j].getRed(),color[i][j].getGreen(),color[i][j].getBlue());
                //screen.setCharacter(i+x,j+y,new TextCharacter(' ').withBackgroundColor(pixelColor));
            }
        }
        //this.color = pixelColor;*/
    }

    public Color[][] imgGetter(String file){
        URL resource = getClass().getResource("/" + file + ".png");
        try {
            image = ImageIO.read(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(int i = 0;i<x;i++){
            for(int j = 0;j<y;j++){
                color[i][j] = new Color(image.getRGB(i,j));
            }
        }
        return color;
    }

    public Color[][] getColor(){
        return color;
    }
}
