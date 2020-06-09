package image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageCrop1 {
	public static void main(String[] args) throws IOException {
		BufferedImage img = ImageIO.read(new File("image/crop1.jpg"));
		int width = img.getWidth();
		int height = img.getHeight();
		System.out.println(width);
		System.out.println(height);
	}
}