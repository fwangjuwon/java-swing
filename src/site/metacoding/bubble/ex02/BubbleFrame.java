package site.metacoding.bubble.ex02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * ����: ���ȭ�鼳��, ĳ���� �߰�!!
 * 
 */
public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		setVisible(true); // ���ο� paintComponent() ȣ���ڵ尡 �ִ�.
	}

	// ���� ������ new�ϴ� ��
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("Image/backgroundMap.png"));
		setContentPane(backgroundMap); // ��׶��� ȭ�� ����

		player = new Player(); // player�� jlabel�̴ϱ� �ص� ��
		add(player);
	}

	// ���� ������ ���� ��� ����
	private void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // jframe�� �⺻ jpanel�� ���̾ƿ� ���� !
		setLocationRelativeTo(null); // �η� �ָ� ��� ��ġ ������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ�� �� jvm���� �����ϱ�
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}
