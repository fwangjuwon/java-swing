package site.metacoding.bubble.ex06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * ����: �����׽�Ʈ!!
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	int count = 0;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		initService();
		setVisible(true); // ���ο� paintComponent() ȣ���ڵ尡 �ִ�.
	}

	private void initService() {
		new Thread(new BackgroundMapService(player)).start(); // ���ٷ� ���ϴ� ����: �̹� runnable�������ϱ� �׳� backgroundmapservice��
																// �־��ָ� �ȴ�. player�� ����!
	}

	// ���� ������ new�ϴ� ��
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("Image/test.png"));
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

	private void initListener() { // Ÿ�ٴ���� ����! Ű���崩���°Ŵϱ�,,, ��� ����� jframe
		addKeyListener(new KeyListener() { // Ÿ���� keylistener���� �� �ִ�.

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) { // Ű���� ������ ����
				// �ݹ�޼���: ��� ȣ�����ش�. �ٸ��Լ��� �μ��� ���޵ȴ�.
				System.out.println("Ű���� ������");

				if (e.getKeyCode() == 39) {
					// isright�� false -> isright�� private�̴ϱ� player���� getter,setter���������Ѵ�.
					player.setRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					// isleft �� false
					player.setLeft(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) { // Ű���带 ������
				// System.out.println("Ű���� ������: " + e.getKeyCode()); // ����: 37, ������: 39, ��: 38,
				// �Ʒ�: 40
				// �����̴� å���� player�� ���� �����Ƿ�, ���⼭�� ���� ���ְ� playerŬ�������� �޼ҵ带 �������Ѵ�.

				if (e.getKeyCode() == 39) { // Ű���带 ������ �ִ� ���� right�޼��带 �ѹ��� �����ϰ� �ʹ�!!
					if (player.isRight() == false) {
						player.right();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (player.isLeft() == false) {
						player.left();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) { // upŰ�� ������ ������ �� ������ ��� �̺�Ʈ
																// ������ ����Ѵ� > ���ʿ� �� ������ �������
																// �ʰ� �Ϸ��� �� ������ ���ϰ� ���ƾߵȴ�.
																// ù��° ���: �׳� �� ������ ���ּ� �̺�Ʈ
																// ���� ����� ���Ѵ�.
					// Ű���带 ������ ���� ������, ������ ��ϵǱ� ������ ��� �����

					// �ι�° ���: �޼��� ���ο��� if�б� ó���� �̺�Ʈ ������ ����� ������, ������ �ȵȴ�.
					if (player.isJump() == false) { // �̺�Ʈ ������ ��ϵ� �� 2�� ������ �˻��ϴϱ� ������ false��.
						System.out.println(count);
						count++;
						player.jump();
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}
