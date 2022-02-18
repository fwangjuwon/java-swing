package site.metacoding.practice;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {
	private static final String TAG = "Player: ";

	// ��������
	private BackgroundMap backgroundMap;
	// private BufferedImage image;

	private ImageIcon playerR, playerL;
	private int x, y;

	private boolean isLeft, isRight, isUp, isDown; // false�� �ʱ�ȭ ��Ű�� while�� �ٲ���.

	private boolean leftWallCrush, rightWallCrush;

	public boolean isLeftWallCrush() {
		return leftWallCrush;
	}

	public void setLeftWallCrush(boolean leftWallCrush) {
		this.leftWallCrush = leftWallCrush;
	}

	public boolean isRightWallCrush() {
		return rightWallCrush;
	}

	public void setRightWallCrush(boolean rightWallCrush) {
		this.rightWallCrush = rightWallCrush;
	}

	public Player(BackgroundMap backgroundMap) {
		this.backgroundMap = backgroundMap;
		playerR = new ImageIcon("Image/playerR.png");
		playerL = new ImageIcon("Image/playerL.png");

		x = 70;
		y = 535;

		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // jlabel�� ��ġ�� �����ѰŤ�����

		isRight = false;
		isLeft = false;
		isUp = false;
		isDown = false;

		leftWallCrush = false;
		rightWallCrush = false;
	}

	public ImageIcon getPlayerR() {
		return playerR;
	}

	public void setPlayerR(ImageIcon playerR) {
		this.playerR = playerR;
	}

	public ImageIcon getPlayerL() {
		return playerL;
	}

	public void setPlayerL(ImageIcon playerL) {
		this.playerL = playerL;
	}

	private void �ٴ��浹����() {
		// System.out.println(TAG + "�ٴ��浹�����");
		int bottomColor = backgroundMap.getImage().getRGB(getX() + 10, getY() + 50 + 5) // -1
				+ backgroundMap.getImage().getRGB(getX() + 50 - 10, getY() + 50 + 5); // -1
		if (bottomColor != -2) { // �ٴ��� ���
			System.out.println("�ٴڿ� ��ֹ� ");
			isDown = false;
		} else {
			if (isUp == false && isDown == false) {
				down();
			}
		}

	}

	private void ���ʺ��浹����() { // ���ο� �����尡 �����Ű�°� ���� ������������ Ȯ���ϸ� ��->map�� �����ؼ� ������ �˾ƾߵȴ�.
		// System.out.println(TAG + "���� �浹 �����!");
		Color leftColor = new Color(backgroundMap.getImage().getRGB(getX() - 10, getY() + 25));

		if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
			System.out.println(TAG + "���� �� �浹");
			// LEFT WALL CRASH���� = true ����
			leftWallCrush = true;
			isLeft = false;
		}
	}

	private void �����ʺ��浹����() {
		// System.out.println(TAG + "������ �� �浹 ��� ��");
		Color rightColor = new Color(backgroundMap.getImage().getRGB(getX() + 50 + 15, getY() + 25));

		if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
			System.out.println(TAG + "������ �� �浹");
			rightWallCrush = true;
			isRight = false;
		}
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public boolean isUp() {
		return isUp;
	}

	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}

	public boolean isDown() {
		return isDown;
	}

	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}

	@Override
	public void left() {
		System.out.println(TAG + "left()");
		isLeft = true;
		setIcon(playerL);
		new Thread(() -> {
			try {
				while (isLeft) {
					x = x - 4;
					setLocation(x, y);// paintcomponent()�� �ڵ� ȣ�����ش�. ���������� repaint�ȴ�.
					Thread.sleep(10);

					���ʺ��浹����();
					�ٴ��浹����();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();

	}

	@Override
	public void right() {
		System.out.println(TAG + "right()");
		isRight = true;
		setIcon(playerR);
		new Thread(() -> {
			try {
				while (isRight) {
					x = x + 4;
					setLocation(x, y);// paintcomponent()�� �ڵ� ȣ�����ش�. ���������� repaint�ȴ�.
					Thread.sleep(10);

					�����ʺ��浹����();
					�ٴ��浹����();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();

	} // �̰� ����� �� ( ������ ����� ��) repaint�� ȣ��ȴ�.

	@Override
	public void up() {
		System.out.println(TAG + "��!");
		isUp = true;
		new Thread(() -> {
			for (int i = 0; i < 130 / 2; i++) {
				y = y - 2;
				setLocation(x, y);
				try {
					Thread.sleep(5); // thread�ɷ��� try- catch �ɾ������
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			isUp = false;
			// down();
		}).start();

	}

	@Override
	public void down() {
		// �ٴ��浹����();

		System.out.println("�ٿ�!");
		isDown = true;
		new Thread(() -> {
			while (isDown) {
				y = y + 2;
				setLocation(x, y);
				try {
					Thread.sleep(3); // thread�ɷ��� try- catch �ɾ������
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			isDown = false;
		}).start();
	}
}
