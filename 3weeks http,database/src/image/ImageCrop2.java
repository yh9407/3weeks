package image;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
//이미지 줄이기.
public class ImageCrop2 {
	public static void main(String[] args) throws IOException {
		BufferedImage img = ImageIO.read(new File("image/crop1.jpg"));
		int width = img.getWidth() / 2;
		int height = img.getHeight() / 2;//줄임.
		Image resizeImg = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = newImage.getGraphics();
		g.drawImage(resizeImg, 0, 0, null);
		ImageIO.write(newImage, "jpg", new File("image/crop1c.jpg"));//파일저장.
	}
}