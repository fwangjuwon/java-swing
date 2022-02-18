package site.metacoding.bubble.ex09;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class BackgroundMapService implements Runnable {

	private Player player;
	private BufferedImage image;

	public BackgroundMapService(Player player) {
		this.player = player;
		try {
			image = ImageIO.read(new File("Image/backgroundMapService.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			// 색상 확인
			Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
			// System.out.println("leftColor : " + leftColor);
			// System.out.println("rightColor : " + rightColor);

			System.out.println(image.getRGB(player.getX(), player.getY() + 50 + 5)); // 흰색 값 이 -1이므로, -1만 아니면 다 바닥에 뭔가
			// 있는것! 왼쪽 x바닥, 오른쪽 x바닥의 합이
			// -2일때만 공중에 떠 있는 것 (바닥이 없는것)ㅎㅎ

			int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5) // -1
					+ image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5); // -1

			if (bottomColor != -2) { // 바텀 충돌 상태이다 -> 내려오는게 스탑되어야함: 밑으로 내려오는 메서드가 없다 //down은 for문 걸리면 안돼 up, down으로
				// 메소드를 구분시키자. > code refactoring!
				player.setDown(false);
			} else {
				if (player.isUp() == false && player.isDown() == false) {
					player.down();
				}
			}
			// 바텀이 흰색이면 down 호출!! elseif로 불러오자.ㅎㅎㅎㅎ

			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				// System.out.println("왼쪽 벽에 충돌함");
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				// System.out.println("오른쪽 벽에 충돌함");
				player.setRightWallCrash(true);
				player.setRight(false);
			} else {
				player.setRightWallCrash(false);
				player.setLeftWallCrash(false);
			}

			try {
				Thread.sleep(10); // 0.01초마다 if, else 체크
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}