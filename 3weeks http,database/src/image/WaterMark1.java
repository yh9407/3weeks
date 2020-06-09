package image;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class WaterMark1 {
	public static void main(String[] args) throws IOException {
// 원본 이미지 및 워터마크로 사용할 로고 이미지 가져오기
		BufferedImage sourceImage = ImageIO.read(new File("image/wm1.jpg"));
		BufferedImage watermarkImage = ImageIO.read(new File("image/logo.jpg"));
// 워터마크를 추가하기 위해 원본 이미지의 graphics 객체 가져오기
		Graphics g = sourceImage.getGraphics();
// 워터마크가 그려질 위치 지정 (원본 이미지의 중앙)
		int x = (sourceImage.getWidth() - watermarkImage.getWidth()) / 2;
		int y = (sourceImage.getHeight() - watermarkImage.getHeight()) / 2;
//원본 이미지에 워터마크 이미지 그리기
		g.drawImage(watermarkImage, x, y, null);
//새로운 파일로 저장
		ImageIO.write(sourceImage, "jpg", new File("image/wm1c.jpg"));
	}
}