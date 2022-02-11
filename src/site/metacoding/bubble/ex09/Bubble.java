package site.metacoding.bubble.ex09;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel {

	private BubbleFrame context;
	private Player player;

	private int x;
	private int y;
	private ImageIcon bubble, bomb;

	private boolean left;
	private boolean right;

	public Bubble(BubbleFrame context) {
		this.context = context;
		this.player = context.getPlayer();
		initObject();
		initSetting();

		// 일단 방향 체크를 해야한다. left, right일지
		if (player.getDirection() == 1) {
			right();
		} else if (player.getDirection() == -1) {
			left();
		}
	}

	private void initObject() {
		bubble = new ImageIcon("Image/bubble.png");
		bomb = new ImageIcon("Image/bomb.png");
	}

	private void initSetting() {
		x = player.getX();
		y = player.getY();
		setIcon(bubble);
		setSize(50, 50);
		setLocation(x, y);
		left = false;
		right = false;
	}

	public void left() {
		left = true;
		new Thread(() -> {
			try {
				for (int i = 0; i < 400; i++) {
					x = x - 10;
					setLocation(x, y);
					Thread.sleep(10);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}).start();
	}

	public void right() {
		right = true;
		new Thread(() -> {
			try {
				for (int i = 0; i < 400; i++) {
					x = x + 10;
					setLocation(x, y);
					Thread.sleep(10);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}).start();
	}
}