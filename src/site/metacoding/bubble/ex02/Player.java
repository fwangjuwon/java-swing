package site.metacoding.bubble.ex02;

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

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("Image/playerR.png");
	}

	private void initSetting() {
		x = 70;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // ���������� paintcomponentȣ������ //���� ������ �Ͼ��, �׸��� �ٽ� �׷�����

	}
}