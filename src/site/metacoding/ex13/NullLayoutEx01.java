package site.metacoding.ex13;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NullLayoutEx01 extends MyFrame {

	int x = 0;
	int y = 0;

	public NullLayoutEx01() {
		super(300, 300);

		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(null);

		JButton btn1 = new JButton("¹öÆ°1");

		btn1.setSize(100, 50);
		btn1.setLocation(x, y);

		panel.add(btn1);

		setVisible(true);

		new Thread(() -> {
			for (int i = 0; i < 200; i++) {
				try {
					Thread.sleep(50);
					btn1.setLocation(x++, y++);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public static void main(String[] args) {
		new NullLayoutEx01();
	}

}