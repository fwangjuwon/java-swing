package site.metacoding.practice;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class BubbleApp extends JFrame implements Init {

	private BubbleApp mContext = this;
	private static final String TAG = "BubbleApp: "; // 자기 클래스 이름을 적는다. 항상 태그는 클래스마다 다 건다. // 이 두개 그냥 메인에 고정!
	private BackgroundMap backgroundMap; // 얘들 만들어줘야 뜬다.
	private Player player; // 얘들 만들어줘야 뜬다. -> 메모리에 띄우자 init object에서

	public BubbleApp() { // 생성자 만들고
		// System.out.println(TAG + "생성자 실행"); //tag를 붙여서 적는게 편하다. 실행되는거 확인되면 주석처리
		initObject();
		initSetting();
		initListener();

		setVisible(true);
	}

	public static void main(String[] args) {
		new BubbleApp(); // 얘가 게임을 스타트하는거
	}

	@Override
	public void initObject() {
		backgroundMap = new BackgroundMap();
		setContentPane(backgroundMap);
		player = new Player(backgroundMap);
		add(player);
	}

	@Override
	public void initSetting() {
		setSize(1000, 640);
		getContentPane().setLayout(null); // JFrame의 기본 JPanel의 레이아웃 설정
		setLocationRelativeTo(null); // 가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭시 JVM 같이 종료하기
	}

	@Override
	public void initListener() { // 강제성이 부여 안되니까 조심해야해 ㅎㅎ
//frame에 키이벤트를 넣자. 
		mContext.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) { // switch에다가는 값을 넣는다. 케이스랑 값을 비교 switch - case - break
				case KeyEvent.VK_RIGHT: // keyevent가 vkright라면 break!
					if (!player.isRight() && !player.isRightWallCrush())
						player.right();
					break; // switch 종료
				case KeyEvent.VK_LEFT:
					if (!player.isLeft() && !player.isLeftWallCrush())
						player.left();
					break;
				case KeyEvent.VK_UP:
					if (!player.isUp() && !player.isDown())
						player.up();
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				}
			}
		});
	}
}
