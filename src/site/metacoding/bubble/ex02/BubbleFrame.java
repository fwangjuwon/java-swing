package site.metacoding.bubble.ex02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 목적: 배경화면설정, 캐릭터 추가!!
 * 
 */
public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		setVisible(true); // 내부에 paintComponent() 호출코드가 있다.
	}

	// 얘의 역할은 new하는 것
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("Image/backgroundMap.png"));
		setContentPane(backgroundMap); // 백그라운드 화면 설정

		player = new Player(); // player가 jlabel이니까 해도 되
		add(player);
	}

	// 얘의 역할은 각종 모든 셋팅
	private void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // jframe의 기본 jpanel의 레이아웃 설정 !
		setLocationRelativeTo(null); // 널로 주면 가운데 배치 ㅎㅎㅎ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭 시 jvm같이 종료하기
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}
