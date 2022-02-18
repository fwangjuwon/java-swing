package site.metacoding.ex13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventEx01 extends JFrame {

	JPanel myPanel; // 위에 선언했으니 new할 때 뜬다. 왜 생성자로 선언안햇찌? 지역변수로 뜨기 때문에, 오래 못가서, 밖에다가 선언함. 내 화면에 필요한
					// container와 component는 다 위에 적어서 heap에서 관리
	JButton btn1, btn2;
	JCheckBox checkBox1;
	JLabel labelText, labelImg; // div박스니까 만들 수 있다

	public EventEx01() {
		initSetting();
		initObject();
		initAssign();
		initListener();

		setVisible(true);
	}

	private void initSetting() {
		setSize(300, 300);
		setLocationRelativeTo(null); // 프레임 화면 중앙 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭 시 main 종료 -> 3
	}

	private void initObject() {

		myPanel = new JPanel();
		btn1 = new JButton("버튼1");
		btn2 = new JButton("버튼2");
		checkBox1 = new JCheckBox();
		labelText = new JLabel("레이블1");
		labelImg = new JLabel(new ImageIcon("image/cat.jpg")); // 경로 넣어야한다. 상대경로 시작위치 지정: 내 프로젝트 폴더위치부터 (java-swing)!!

	}

	private void initAssign() {
		add(myPanel);
		myPanel.add(btn1);
		myPanel.add(btn2);
		myPanel.add(checkBox1);
		myPanel.add(labelText);
		myPanel.add(labelImg);
	}

	private void initListener() {
		checkBox1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) { // os가 e라는 변수가 체크가 됐는지, 안됐는지 정보를 전달한다.
				// TODO Auto-generated method stub
				System.out.println(e.toString());
				System.out.println(e.getStateChange());

				if (e.getStateChange() == 1) {

					System.out.println("체크 됐습니다.");
				} else {
					System.out.println("체크 해제됐습니다");
				}
			}
		});

		// 윈도우야 지켜봐조, 이 버튼을!!
		btn1.addActionListener(new ActionListener() {

			// 버튼이 클릭되면 윈도우가 해당 메서드를 콜백해준다.
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼1이 클릭되었습니다");
			}

		});

		btn2.addActionListener((ActionEvent e) -> {
			System.out.println("버튼2가 클릭되었습니다.");
		});
	}

	public static void main(String[] args) {
		new EventEx01();
	}
}
