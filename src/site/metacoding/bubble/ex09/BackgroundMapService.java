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
			// ���� Ȯ��
			Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
			Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
			// System.out.println("leftColor : " + leftColor);
			// System.out.println("rightColor : " + rightColor);

			System.out.println(image.getRGB(player.getX(), player.getY() + 50 + 5)); // ��� �� �� -1�̹Ƿ�, -1�� �ƴϸ� �� �ٴڿ� ����
			// �ִ°�! ���� x�ٴ�, ������ x�ٴ��� ����
			// -2�϶��� ���߿� �� �ִ� �� (�ٴ��� ���°�)����

			int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5) // -1
					+ image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5); // -1

			if (bottomColor != -2) { // ���� �浹 �����̴� -> �������°� ��ž�Ǿ����: ������ �������� �޼��尡 ���� //down�� for�� �ɸ��� �ȵ� up, down����
				// �޼ҵ带 ���н�Ű��. > code refactoring!
				player.setDown(false);
			} else {
				if (player.isUp() == false && player.isDown() == false) {
					player.down();
				}
			}
			// ������ ����̸� down ȣ��!! elseif�� �ҷ�����.��������

			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				// System.out.println("���� ���� �浹��");
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				// System.out.println("������ ���� �浹��");
				player.setRightWallCrash(true);
				player.setRight(false);
			} else {
				player.setRightWallCrash(false);
				player.setLeftWallCrash(false);
			}

			try {
				Thread.sleep(10); // 0.01�ʸ��� if, else üũ
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}