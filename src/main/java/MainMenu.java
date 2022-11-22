import com.googlecode.lanterna.graphics.TextGraphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.security.PublicKey;

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
        BufferedImage image = ImageIO.read(getClass().getResource("/resources/hero.png"));
    }
}
