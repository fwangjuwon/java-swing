package site.metacoding.bubble.ex03;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 목적: 캐릭터 좌우 이동! (키보드 프레스를 주시하고 있는 listener를 만들어야한다) 플레이어는 움직이는 책임이 있다.
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
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

	private void initListener() { // 타겟대상이 없다! 키보드누르는거니까,,, 사실 대상은 jframe
		addKeyListener(new KeyListener() { // 타입은 keylistener넣을 수 있다.

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) { // 키보드 누른걸 떼면
				// 콜백메서드: 대신 호출해준다. 다른함수에 인수로 전달된다.
				System.out.println("키보드 릴리즈");
			}

			@Override
			public void keyPressed(KeyEvent e) { // 키보드를 누르면
				System.out.println("키보드 프레스: " + e.getKeyCode()); // 왼쪽: 37, 오른쪽: 39, 위: 38, 아래: 40
				// 움직이는 책임은 player가 갖고 있으므로, 여기서는 선언만 해주고 player클래스에서 메소드를 만들어야한다.

				if (e.getKeyCode() == 39) {
					player.right(); // player를 밖에 놔둔 이유.
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.left();
				}
			}
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}
