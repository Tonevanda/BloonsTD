package base;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Reader {

    private BufferedImage image;

    public Reader(String file) throws IOException {
        BufferedImage image = ImageIO.read(getClass().getResource("/resources/" + file + ".png"));

    }

    public byte[] getBmp() throws IOException {
        image.getGraphics().drawImage();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "bmp", baos);
        baos.flush();
        byte[] bytes = baos.toByteArray();
        baos.close();
    }

}
