package site.metacoding.bubble.ex06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 목적: 색상테스트!!
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	int count = 0;

	public BubbleFrame() {
		initObject();
		initSetting();
		initListener();
		initService();
		setVisible(true); // 내부에 paintComponent() 호출코드가 있다.
	}

	private void initService() {
		new Thread(new BackgroundMapService(player)).start(); // 람다로 안하는 이유: 이미 runnable돼있으니까 그냥 backgroundmapservice만
																// 넣어주면 된다. player에 의존!
	}

	// 얘의 역할은 new하는 것
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("Image/test.png"));
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

				if (e.getKeyCode() == 39) {
					// isright를 false -> isright는 private이니까 player에서 getter,setter만들어줘야한다.
					player.setRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					// isleft 를 false
					player.setLeft(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) { // 키보드를 누르면
				// System.out.println("키보드 프레스: " + e.getKeyCode()); // 왼쪽: 37, 오른쪽: 39, 위: 38,
				// 아래: 40
				// 움직이는 책임은 player가 갖고 있으므로, 여기서는 선언만 해주고 player클래스에서 메소드를 만들어야한다.

				if (e.getKeyCode() == 39) { // 키보드를 누르고 있는 동안 right메서드를 한번만 실행하고 싶다!!
					if (player.isRight() == false) {
						player.right();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (player.isLeft() == false) {
						player.left();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) { // up키를 누르고 있으면 이 스택을 계속 이벤트
																// 루프에 등록한다 > 애초에 이 스택이 실행되지
																// 않게 하려면 이 스택을 못하게 막아야된다.
																// 첫번째 방법: 그냥 이 스택을 없애서 이벤트
																// 루프 등록을 안한다.
					// 키보드를 누르고 있을 때마다, 스택이 등록되기 때문에 계속 실행됨

					// 두번째 방법: 메서드 내부에서 if분기 처리는 이벤트 루프에 등록은 되지만, 실행은 안된다.
					if (player.isJump() == false) { // 이벤트 루프에 등록된 후 2초 지나서 검사하니까 무조건 false다.
						System.out.println(count);
						count++;
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
