package site.metacoding.bubble.ex08;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * �÷��̾��� ����: ����! ���� �� �ε���, ������ �� �ε��� ����
 */
public class Player extends JLabel {

	private int x;
	private int y;
	private ImageIcon playerR;
	private ImageIcon playerL;

	private boolean isRight;
	private boolean isLeft;
	private boolean up; // ��������(up,down)
	private boolean down;

	private boolean leftWallCrash; // private�Ƿ� �ٸ� ������ �� �� ���� -> getter,setter�������Ѵ�.
	private boolean rightWallCrash; // ���´� ������ �����Ѵ� left, right�޼ҵ尡 �����Ѵ� -> ������� left,right�޼ҵ� �ȿ��� �ϸ� ������ �ʹ� �����ϹǷ�
									// backgroundmapservice�� �޼ҵ忡 �ִ´�.

	private static final int JUMPSPEED = 2; // (������ �� Y = -���� �ȴ�. )
	private static final int SPEED = 4; // (������ �� Y = -���� �ȴ�. )

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

	public Player() { // �����ڵ� �޼����.
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
		rightWallCrash = false; // �����ڿ��� �ʱ�ȭ
	}

	public void left() {
		isLeft = true;
		// rightWallCrash = false; // ����Ŭ���� ��� ���� ���� �ȴ�.
		setIcon(playerL);
		System.out.println("���� �̵�");

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

	// Ű���� ������ Ű , �������¿��� �����Ǵ°� ����
	public void up() {

		System.out.println("��!!"); // ��,�ٿ� å�� �и� ��Ű��.
		up = true; // �޼��� ���۽ÿ� true, ������ false >for�� 2�� (�ö� ��, ������ ��)������. -> 0~130�������鼭 �ö�
		// up ������ ��, sleep(5)
		// ���̴� �˾Ƽ� ���ϱ�

		new Thread(() -> {
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y - JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(5); // thread�ɷ��� try- catch �ɾ������
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			up = false;
			down();
		}).start();
	}

	public void down() {

		System.out.println("�ٿ�!!"); // ��,�ٿ� å�� �и� ��Ű��.
		down = true; // �޼��� ���۽ÿ� true, ������ false >for�� 2�� (�ö� ��, ������ ��)������. -> 0~130�������鼭 �ö�
		// up ������ ��, sleep(5)
		// ���̴� �˾Ƽ� ���ϱ�

		new Thread(() -> {

			// down������ ��, sleep(3)
			while (down) {
				y = y + JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(3); // thread�ɷ��� try- catch �ɾ������
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			down = false;
		}).start();
		// down�� false�Ǵ� �� ����! ��׶��� ���񽺿��� ����
	}

	public void right() {
		isRight = true; // ������ ��ư�� ���� ����(release)���� true
		// leftWallCrash = false; // ����Ŭ���� ��� ���� ���� �ȴ�.
		setIcon(playerR);
		System.out.println("������ �̵�");

		new Thread(() -> { // ���ο� �����尡 main������ ��� �� �� �Ѵ� -> ���ν������ ���� �ȹٺ� -> ȣ���� �Ȼ���
			while (isRight) {
				x = x + SPEED; // ������ ���¸� �ٲ۰�.
				setLocation(x, y);
				try {
					Thread.sleep(10); // thread�ɷ��� trycatch �ɾ������
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
