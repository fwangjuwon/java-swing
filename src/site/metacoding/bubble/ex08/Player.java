package site.metacoding.bubble.ex08;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 플레이어의 목적: 점프! 왼쪽 벽 부딪힘, 오른쪽 벽 부딪힘 감지
 */
public class Player extends JLabel {

	private int x;
	private int y;
	private ImageIcon playerR;
	private ImageIcon playerL;

	private boolean isRight;
	private boolean isLeft;
	private boolean up; // 점프상태(up,down)
	private boolean down;

	private boolean leftWallCrash; // private므로 다른 곳에서 쓸 수 없다 -> getter,setter만들어야한다.
	private boolean rightWallCrash; // 상태는 행위로 제어한다 left, right메소드가 제어한다 -> 원래라면 left,right메소드 안에서 하면 되지만 너무 복잡하므로
									// backgroundmapservice의 메소드에 넣는다.

	private static final int JUMPSPEED = 2; // (점프할 때 Y = -값이 된다. )
	private static final int SPEED = 4; // (점프할 때 Y = -값이 된다. )

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
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

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public Player() { // 생성자도 메서드다.
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("Image/playerR.png");
		playerL = new ImageIcon("Image/playerL.png");
	}

	private void initSetting() {
		x = 90;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);

		isRight = false;
		isLeft = false;
		up = false;
		down = false;

		leftWallCrash = false;
		rightWallCrash = false; // 생성자에서 초기화
	}

	public void left() {
		isLeft = true;
		// rightWallCrash = false; // 서비스클래스 대신 여기 만들어도 된다.
		setIcon(playerL);
		System.out.println("왼쪽 이동");

		new Thread(() -> {
			while (isLeft) {
				x = x - SPEED;
				setLocation(x, y);

				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	// 키보드 윗방향 키 , 점프상태에서 점프되는것 막기
	public void up() {

		System.out.println("업!!"); // 업,다운 책임 분리 시키자.
		up = true; // 메서드 시작시에 true, 끝나면 false >for로 2번 (올라갈 때, 내려갈 때)돌린다. -> 0~130번돌리면서 올라감
		// up 상태일 때, sleep(5)
		// 높이는 알아서 정하기

		new Thread(() -> {
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(5); // thread걸려면 try- catch 걸어줘야해
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			up = false;
			down();
		}).start();
	}

	public void down() {

		System.out.println("다운!!"); // 업,다운 책임 분리 시키자.
		down = true; // 메서드 시작시에 true, 끝나면 false >for로 2번 (올라갈 때, 내려갈 때)돌린다. -> 0~130번돌리면서 올라감
		// up 상태일 때, sleep(5)
		// 높이는 알아서 정하기

		new Thread(() -> {

			// down상태일 때, sleep(3)
			while (down) {
				y = y + JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(3); // thread걸려면 try- catch 걸어줘야해
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			down = false;
		}).start();
		// down이 false되는 건 삭제! 백그라운드 서비스에서 제어
	}

	public void right() {
		isRight = true; // 오른쪽 버튼을 떼는 순간(release)까지 true
		// leftWallCrash = false; // 서비스클래스 대신 여기 만들어도 된다.
		setIcon(playerR);
		System.out.println("오른쪽 이동");

		new Thread(() -> { // 새로운 스레드가 main스레드 대신 이 일 한다 -> 메인스레드는 이제 안바빠 -> 호ㅏ면 안뻗어
			while (isRight) {
				x = x + SPEED; // 본인의 상태를 바꾼것.
				setLocation(x, y);
				try {
					Thread.sleep(10); // thread걸려면 trycatch 걸어줘야해
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
