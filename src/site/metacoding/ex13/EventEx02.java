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

	// JPanel�� ���� ��ħ�ϴ� �� (�ٽ� �׸���)
	@Override
	protected void paintComponent(Graphics g) { // g = ��!!
		super.paintComponent(g);
		System.out.println("�г��� �ٽ� �׷���");
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
		setLocationRelativeTo(null); // ������ ȭ�� �߾� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ŭ�� �� main ���� -> 3
	}

	@Override
	public void initObject() {
		myPanel = new MyPanel();
		labelText = new JLabel("ù����");
		btn1 = new JButton("���ں���");
		btn2 = new JButton("�׸�����");
	}

	@Override
	public void initAssign() {
		getContentPane().add(myPanel); // jframe�� mypanel�� �ֵ��Ѱž�.
		myPanel.add(labelText);
		myPanel.add(btn1);
		myPanel.add(btn2);
	}

	@Override
	public void initListener() {
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// setText�޼ҵ�� �κк����� �ȴ�.
				labelText.setText("�ι�°����"); // setText�޼���� ���ο� paintComponent�� ��ȣ�����ش�. ��ü �г��� �ٽ� �׷��� ��!! ��ȿ�����̴�!!

			}
		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				myPanel.x = myPanel.x + 30;
				myPanel.y = myPanel.y + 30;

				System.out.println(myPanel.x);
				System.out.println(myPanel.y);

				// repaint(); // jframe��!!! myframe�� �ٽ� �׷��� ���̴�. -> ��ȿ��! �гθ� ������Ʈ�ϴ°� ����.
				myPanel.repaint();
			}
		});
	}

	public static void main(String[] args) {
		new EventEx02();
	}

}
