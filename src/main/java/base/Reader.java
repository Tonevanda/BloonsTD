package base;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

public class Reader {
    private Color[][] color;
    private int x;
    private int y;
    private BufferedImage image;


    public Reader(String file,int x, int y){
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
    }
    public Color[][] getColor(){
        return color;
    }


}
