package site.metacoding.ex13;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyPanel extends JPanel {

	int x = 100;
	int y = 200;

	// JPanel을 새로 고침하는 것 (다시 그린다)
	@Override
	protected void paintComponent(Graphics g) { // g = 붓!!
		super.paintComponent(g);
		System.out.println("패널이 다시 그려짐");
		g.drawLine(10, 20, x, y);
	}
}

public class EventEx02 extends JFrame implements UserInterface {

	MyPanel myPanel;
	JLabel labelText;
	JButton btn1;
	JButton btn2;

	public EventEx02() {
		initSetting();
		initObject();
		initAssign();
		initListener();

		setVisible(true);
	}

	@Override
	public void initSetting() {
		setSize(500, 500);
		setLocationRelativeTo(null); // 프레임 화면 중앙 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭 시 main 종료 -> 3
	}

	@Override
	public void initObject() {
		myPanel = new MyPanel();
		labelText = new JLabel("첫글자");
		btn1 = new JButton("글자변경");
		btn2 = new JButton("그림변경");
	}

	@Override
	public void initAssign() {
		getContentPane().add(myPanel); // jframe에 mypanel을 애드한거야.
		myPanel.add(labelText);
		myPanel.add(btn1);
		myPanel.add(btn2);
	}

	@Override
	public void initListener() {
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// setText메소드는 부분변경이 된다.
				labelText.setText("두번째글자"); // setText메서드는 내부에 paintComponent를 재호출해준다. 전체 패널이 다시 그려진 것!! 비효율적이다!!

			}
		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				myPanel.x = myPanel.x + 30;
				myPanel.y = myPanel.y + 30;

				System.out.println(myPanel.x);
				System.out.println(myPanel.y);

				// repaint(); // jframe꺼!!! myframe이 다시 그려진 것이다. -> 비효율! 패널만 리페인트하는게 낫다.
				myPanel.repaint();
			}
		});
	}

	public static void main(String[] args) {
		new EventEx02();
	}

}
