package image;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class WaterMark1 {
	public static void main(String[] args) throws IOException {
// ���� �̹��� �� ���͸�ũ�� ����� �ΰ� �̹��� ��������
		BufferedImage sourceImage = ImageIO.read(new File("image/wm1.jpg"));
		BufferedImage watermarkImage = ImageIO.read(new File("image/logo.jpg"));
// ���͸�ũ�� �߰��ϱ� ���� ���� �̹����� graphics ��ü ��������
		Graphics g = sourceImage.getGraphics();
// ���͸�ũ�� �׷��� ��ġ ���� (���� �̹����� �߾�)
		int x = (sourceImage.getWidth() - watermarkImage.getWidth()) / 2;
		int y = (sourceImage.getHeight() - watermarkImage.getHeight()) / 2;
//���� �̹����� ���͸�ũ �̹��� �׸���
		g.drawImage(watermarkImage, x, y, null);
//���ο� ���Ϸ� ����
		ImageIO.write(sourceImage, "jpg", new File("image/wm1c.jpg"));
	}
}