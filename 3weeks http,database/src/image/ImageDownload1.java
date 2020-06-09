package image;
//이미지 다운로드
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class ImageDownload1 {
	public static void main(String[] args) throws IOException {
		String imgUrl = "http://ggoreb.com/images/luffy.jpg";
		URL url = new URL(imgUrl);
		BufferedImage img = ImageIO.read(url);
		ImageIO.write(img, "jpg", new File("luffy.jpg"));
	}
}