package site.metacoding.bubble.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 1. jframe의 목적: 배경화면 설정, 플레이어 추가 2. jframe의 목적: 캐릭터를 좌우 이동 시키기(키보드 프레스를 주시하는
 * listener를 만들자) 3. jframe의 목적: 플레이어를 부드럽게 이동시키고, 키보드를 누르는 동안 right()를 한번만
 * 실행시키자. 4. jframe의 목적: 플레이어를 점프 시키자!
 */

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() { // 생성자
		initObject();
		initSetting();
		initListener();
		setVisible(true); // 내부에 paintComponent호출코드 있음
	}

	// new 하는 역할
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("Image/backgroundMap.png"));
		setContentPane(backgroundMap); // 배경화면이 설정되었다!

		player = new Player(); // 플레이어 객체 호출
		add(player); // 플레이어를 올린다.
	}

	// 각종 세팅들
	private void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null);// jframe의 기본 jpanel의 레이아웃 설정
		setLocationRelativeTo(null); // null - 가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X버튼클릭시 종료
	}

	private void initListener() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("키보드 릴리즈");

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.setRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.setLeft(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (player.isRight() == false) {
						player.right();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (player.isLeft() == false) {
						player.left();
					}
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (player.isJump() == false) {
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
