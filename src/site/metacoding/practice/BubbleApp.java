package site.metacoding.practice;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class BubbleApp extends JFrame implements Init {

	private BubbleApp mContext = this;
	private static final String TAG = "BubbleApp: "; // �ڱ� Ŭ���� �̸��� ���´�. �׻� �±״� Ŭ�������� �� �Ǵ�. // �� �ΰ� �׳� ���ο� ����!
	private BackgroundMap backgroundMap; // ��� �������� ���.
	private Player player; // ��� �������� ���. -> �޸𸮿� ����� init object����

	public BubbleApp() { // ������ �����
		// System.out.println(TAG + "������ ����"); //tag�� �ٿ��� ���°� ���ϴ�. ����Ǵ°� Ȯ�εǸ� �ּ�ó��
		initObject();
		initSetting();
		initListener();

		setVisible(true);
	}

	public static void main(String[] args) {
		new BubbleApp(); // �갡 ������ ��ŸƮ�ϴ°�
	}

	@Override
	public void initObject() {
		backgroundMap = new BackgroundMap();
		setContentPane(backgroundMap);
		player = new Player(backgroundMap);
		add(player);
	}

	@Override
	public void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // JFrame�� �⺻ JPanel�� ���̾ƿ� ����
		setLocationRelativeTo(null); // ��� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ���� JVM ���� �����ϱ�
	}

	@Override
	public void initListener() { // �������� �ο� �ȵǴϱ� �����ؾ��� ����
//frame�� Ű�̺�Ʈ�� ����. 
		mContext.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) { // switch���ٰ��� ���� �ִ´�. ���̽��� ���� �� switch - case - break
				case KeyEvent.VK_RIGHT: // keyevent�� vkright��� break!
					if (!player.isRight() && !player.isRightWallCrush())
						player.right();
					break; // switch ����
				case KeyEvent.VK_LEFT:
					if (!player.isLeft() && !player.isLeftWallCrush())
						player.left();
					break;
				case KeyEvent.VK_UP:
					if (!player.isUp() && !player.isDown())
						player.up();
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				}
			}
		});
	}
}
