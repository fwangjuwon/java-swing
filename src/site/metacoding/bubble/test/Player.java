package site.metacoding.bubble.test;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 1. �÷��̾��� ����: ȭ�鿡 ����, ��ǥ�� �ִ�. 2. �÷��̾��� ����: �¿� �̵� 3. �÷��̾��� ����: �¿� �̵� &
 * getter,setter����� & left, right�޼ҵ忡 ������ �߰� ��Ű�� 4. �÷��̾��� ����: ������Ű��
 */
public class Player extends JLabel {

	private int x;
	private int y;
	private ImageIcon playerR;
	private ImageIcon playerL;
	private boolean isRight;
	private boolean isLeft;
	private boolean isJump;

	private static final int JUMPSPEED = 2; // (������ �� Y = -���� �ȴ�. )
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
		setLocation(x, y); // ���������� paintcomponentȣ��
		isLeft = false;
		isRight = false;
		isJump = false; // �����ڿ��� ��� �ʱ�ȭ ��Ŵ
	}

	public void left() { // public �ؾߵȴ�. > �ٸ����� ȣ���� �����ؾߵǴϱ�!
		isLeft = true;
		setIcon(playerL);
		System.out.println("���� �̵�");

		new Thread(() -> {
			while (isLeft) {
				x = x - SPEED;
				setLocation(x, y); // ��ġ ���� ���� paintcomponent �ϴ� ��
				try {
					Thread.sleep(10); // �����带 ��� �������Ѿ��Ѵ�.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}).start();
	}

	public void right() {
		isRight = true;
		setIcon(playerR);
		System.out.println("������ �̵�");
		new Thread(() -> {
			while (isRight) {
				x = x + SPEED;
				setLocation(x, y); // ��ġ ���� ���� paintcomponent �ϴ� ��
				try {
					Thread.sleep(10); // �����带 ��� �������Ѿ��Ѵ�.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}).start();
	}

	public void jump() {
		isJump = true; // isjump�� true���� ���� false���� for���� �ι� ���� ���ο� thread���� �ñ��.
		System.out.println("����!");

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