package site.metacoding.bubble.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 1. jframe�� ����: ���ȭ�� ����, �÷��̾� �߰� 2. jframe�� ����: ĳ���͸� �¿� �̵� ��Ű��(Ű���� �������� �ֽ��ϴ�
 * listener�� ������) 3. jframe�� ����: �÷��̾ �ε巴�� �̵���Ű��, Ű���带 ������ ���� right()�� �ѹ���
 * �����Ű��. 4. jframe�� ����: �÷��̾ ���� ��Ű��!
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() { // ������
		initObject();
		initSetting();
		initListener();
		setVisible(true); // ���ο� paintComponentȣ���ڵ� ����
	}

	// new �ϴ� ����
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("Image/backgroundMap.png"));
		setContentPane(backgroundMap); // ���ȭ���� �����Ǿ���!

		player = new Player(); // �÷��̾� ��ü ȣ��
		add(player); // �÷��̾ �ø���.
	}

	// ���� ���õ�
	private void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null);// jframe�� �⺻ jpanel�� ���̾ƿ� ����
		setLocationRelativeTo(null); // null - ��� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X��ưŬ���� ����
	}

	private void initListener() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("Ű���� ������");

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.setRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.setLeft(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (player.isRight() == false) {
						player.right();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (player.isLeft() == false) {
						player.left();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (player.isJump() == false) {
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
