package image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageCrop3 {
	public static void main(String[] args) throws IOException {
		BufferedImage img = ImageIO.read(new File("image/crop2.jpg"));
		int width = img.getWidth();
		int height = img.getHeight();
		BufferedImage newImage = img.getSubimage(width / 2 - height / 2, 0, height, height);
		ImageIO.write(newImage, "jpg", new File("image/crop2c.jpg"));
	}
}