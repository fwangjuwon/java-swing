package site.metacoding.practice;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BackgroundMap extends JLabel {

	private ImageIcon backgroundMap;
	private BufferedImage image;

	public ImageIcon getBackgroundMap() {
		return backgroundMap;
	}

	public void setBackgroundMap(ImageIcon backgroundMap) {
		this.backgroundMap = backgroundMap;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public BackgroundMap() {
		try {
			image = ImageIO.read(new File("Image/backgroundMapService.png"));
		} catch (Exception e) {
			e.getStackTrace();
		}

		backgroundMap = new ImageIcon("Image/backgroundMap.png");
		setIcon(backgroundMap); // div박스에 이미지 넣기
	}
}
