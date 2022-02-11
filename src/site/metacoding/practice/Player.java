package site.metacoding.practice;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {
	private static final String TAG = "Player: ";

	// 컴포지션
	private BackgroundMap backgroundMap;
	// private BufferedImage image;

	private ImageIcon playerR, playerL;
	private int x, y;

	private boolean isLeft, isRight, isUp, isDown; // false로 초기화 시키고 while로 바꾸자.

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
		setLocation(x, y); // jlabel의 위치를 설정한거ㅎㅎㅎ

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

	private void 바닥충돌감지() {
		// System.out.println(TAG + "바닥충돌계산중");
		int bottomColor = backgroundMap.getImage().getRGB(getX() + 10, getY() + 50 + 5) // -1
				+ backgroundMap.getImage().getRGB(getX() + 50 - 10, getY() + 50 + 5); // -1
		if (bottomColor != -2) { // 바닥이 흰색
			System.out.println("바닥에 장애물 ");
			isDown = false;
		} else {
			if (isUp == false && isDown == false) {
				down();
			}
		}

	}

	private void 왼쪽벽충돌감지() { // 새로운 스레드가 실행시키는것 벽이 빨간색인지만 확인하면 됨->map에 의존해서 색상을 알아야된다.
		// System.out.println(TAG + "왼쪽 충돌 계산중!");
		Color leftColor = new Color(backgroundMap.getImage().getRGB(getX() - 10, getY() + 25));

		if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
			System.out.println(TAG + "왼쪽 벽 충돌");
			// LEFT WALL CRASH상태 = true 변경
			leftWallCrush = true;
			isLeft = false;
		}
	}

	private void 오른쪽벽충돌감지() {
		// System.out.println(TAG + "오른쪽 벽 충돌 계싼 중");
		Color rightColor = new Color(backgroundMap.getImage().getRGB(getX() + 50 + 15, getY() + 25));

		if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
			System.out.println(TAG + "오른쪽 벽 충돌");
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
					setLocation(x, y);// paintcomponent()를 자동 호출해준다. 내부적으로 repaint된다.
					Thread.sleep(10);

					왼쪽벽충돌감지();
					바닥충돌감지();
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
					setLocation(x, y);// paintcomponent()를 자동 호출해준다. 내부적으로 repaint된다.
					Thread.sleep(10);

					오른쪽벽충돌감지();
					바닥충돌감지();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();

	} // 이게 종료될 때 ( 스택이 종료될 때) repaint가 호출된다.

	@Override
	public void up() {
		System.out.println(TAG + "업!");
		isUp = true;
		new Thread(() -> {
			for (int i = 0; i < 130 / 2; i++) {
				y = y - 2;
				setLocation(x, y);
				try {
					Thread.sleep(5); // thread걸려면 try- catch 걸어줘야해
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
		// 바닥충돌감지();

		System.out.println("다운!");
		isDown = true;
		new Thread(() -> {
			while (isDown) {
				y = y + 2;
				setLocation(x, y);
				try {
					Thread.sleep(3); // thread걸려면 try- catch 걸어줘야해
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			isDown = false;
		}).start();
	}
}
