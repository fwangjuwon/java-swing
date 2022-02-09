package site.metacoding.ex13;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GridLayoutEx01 extends MyFrame {

	public GridLayoutEx01() {
		// super(500, 300); 이 사이즈는 적용이 안 되네..

		JPanel panel = (JPanel) getContentPane();
		panel.setLayout(new GridLayout(0, 4)); // 3개의 열을 가지고, 행은 추가되는 컴포넌트에 의해 결정됨

		JButton btn1 = new JButton("Button1");
		JButton btn2 = new JButton("Button2");
		JButton btn3 = new JButton("Button3");
		JButton btn4 = new JButton("B4");
		JButton btn5 = new JButton("Long Button5");

		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);

		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new GridLayoutEx01();
	}

}
