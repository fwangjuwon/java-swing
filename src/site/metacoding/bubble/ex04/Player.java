package site.metacoding.bubble.ex04;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Administrator �÷��̾�� �¿���� �̵��� �����ϴ�. (x,y��ǥ�� ���� �־���Ѵ�) ������ �����ϴ�. �����
 *         �߻��� �� �ִ�.
 */
public class Player extends JLabel {

	private int x;
	private int y;
	private ImageIcon playerR; // ������ �����ִ� �÷��̾�
	private ImageIcon playerL; // ���� ���� �ִ� �÷��̾�

	private boolean isRight; // ���ʻ��´� �� �� false (default) boolean������ ���� �̸��� is�� ���δ�.
	private boolean isLeft;

	public boolean isRight() { // boolean�� get��� is����.
		return isRight;
	}

	public void setRight(boolean isRight) { // boolean�� setisright �ƴϰ� setright�ȴ�.
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
		setLocation(x, y); // ���������� paintcomponentȣ������ //���� ������ �Ͼ��, �׸��� �ٽ� �׷�����

		isRight = false;
		isLeft = false;
	}

	public void left() { // public�ؾߵȴ�. �ٸ����� ȣ�Ⱑ���ؾߵǱ� ������ //������ȯ�� �Ǿ���Ѵ� > ������ �ٲ���� playerL��
		isLeft = true;
		setIcon(playerL); // ��� �ٲ��ָ� ��
		System.out.println("���� �̵�");

		new Thread(() -> {
			while (isLeft) {
				x = x - 10;
				setLocation(x, y);
				// ��ġ���� ���� paintComponent�ϴ� ��
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void right() {
		isRight = true; // ������ ��ư�� ���� ����(release)���� true
		setIcon(playerR);
		System.out.println("������ �̵�");

		new Thread(() -> { // ���ο� �����尡 main������ ��� �� �� �Ѵ� -> ���ν������ ���� �ȹٺ� -> ȣ���� �Ȼ���
			while (isRight) {
				x = x + 10; // ������ ���¸� �ٲ۰�.
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
