package site.metacoding.bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 1. 플레이어의 목적: 화면에 띄우기, 좌표가 있다. 2. 플레이어의 목적: 좌우 이동 3. 플레이어의 목적: 좌우 이동 &
 * getter,setter만들기 & left, right메소드에 스레드 추가 시키기 4. 플레이어의 목적: 점프시키기
 */
public class Player extends JLabel {

	private int x;
	private int y;
	private ImageIcon playerR;
	private ImageIcon playerL;
	private boolean isRight;
	private boolean isLeft;
	private boolean isJump;

	private static final int JUMPSPEED = 2; // (점프할 때 Y = -값이 된다. )
	private static final int SPEED = 4;

	public boolean isJump() {
		return isJump;
	}

	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}

	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("Image/playerR.png");
		playerL = new ImageIcon("Image/playerL.png");
	}

	private void initSetting() {
		x = 70;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // 내부적으로 paintcomponent호출
		isLeft = false;
		isRight = false;
		isJump = false; // 생성자에서 모두 초기화 시킴
	}

	public void left() { // public 해야된다. > 다른데서 호출이 가능해야되니까!
		isLeft = true;
		setIcon(playerL);
		System.out.println("왼쪽 이동");

		new Thread(() -> {
			while (isLeft) {
				x = x - SPEED;
				setLocation(x, y); // 위치 값을 갖고 paintcomponent 하는 중
				try {
					Thread.sleep(10); // 스레드를 잠시 슬립시켜야한다.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}).start();
	}

	public void right() {
		isRight = true;
		setIcon(playerR);
		System.out.println("오른쪽 이동");
		new Thread(() -> {
			while (isRight) {
				x = x + SPEED;
				setLocation(x, y); // 위치 값을 갖고 paintcomponent 하는 중
				try {
					Thread.sleep(10); // 스레드를 잠시 슬립시켜야한다.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}).start();
	}

	public void jump() {
		isJump = true; // isjump가 true에서 부터 false까지 for문을 두번 돌려 새로운 thread에게 맡긴다.
		System.out.println("점프!");

		new Thread(() -> {
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y + JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(3);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}).start();

		isJump = false;
	}
}