package site.metacoding.bubble.ex03;

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

	}

	public void left() { // public�ؾߵȴ�. �ٸ����� ȣ�Ⱑ���ؾߵǱ� ������ //������ȯ�� �Ǿ���Ѵ� > ������ �ٲ���� playerL��
		setIcon(playerL); // ��� �ٲ��ָ� ��
		System.out.println("���� �̵�");
		x = x - 10;
		setLocation(x, y); // ��ġ���� ���� paintComponent�ϴ� ��
	}

	public void right() {
		setIcon(playerR);
		System.out.println("������ �̵�");
		x = x + 10; // ������ ���¸� �ٲ۰�.
		setLocation(x, y);
	}

}
