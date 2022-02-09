package site.metacoding.bubble.ex05;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * �÷��̾��� ����: ����!
 */
public class Player extends JLabel {

	private int x;
	private int y;
	private ImageIcon playerR;
	private ImageIcon playerL;

	private boolean isRight;
	private boolean isLeft;
	private boolean isJump; // ��������(up,down)

	private static final int JUMPSPEED = 2; // (������ �� Y = -���� �ȴ�. )
	private static final int SPEED = 4; // (������ �� Y = -���� �ȴ�. )

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

	public Player() { // �����ڵ� �޼����.
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
		setLocation(x, y);

		isRight = false;
		isLeft = false;
		isJump = false; // �����ڿ��� �ʱ�ȭ
	}

	public void left() {
		isLeft = true;
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
	public void jump() {

		System.out.println("����!!");
		isJump = true; // �޼��� ���۽ÿ� true, ������ false >for�� 2�� (�ö� ��, ������ ��)������. -> 0~130�������鼭 �ö�
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

			// down������ ��, sleep(3)
			for (int i = 0; i < 130 / JUMPSPEED; i++) {
				y = y + JUMPSPEED;
				setLocation(x, y);
				try {
					Thread.sleep(3); // thread�ɷ��� try- catch �ɾ������
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		isJump = false;
	}

	public void right() {
		isRight = true; // ������ ��ư�� ���� ����(release)���� true
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
