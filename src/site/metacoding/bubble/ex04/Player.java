package site.metacoding.bubble.ex04;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Administrator 플레이어는 좌우상하 이동이 가능하다. (x,y좌표를 갖고 있어야한다) 점프가 가능하다. 방울을
 *         발사할 수 있다.
 */
public class Player extends JLabel {

	private int x;
	private int y;
	private ImageIcon playerR; // 오른쪽 보고있는 플레이어
	private ImageIcon playerL; // 왼쪽 보고 있는 플레이어

	private boolean isRight; // 최초상태는 둘 다 false (default) boolean변수는 보통 이름에 is를 붙인다.
	private boolean isLeft;

	public boolean isRight() { // boolean은 get대신 is쓴다.
		return isRight;
	}

	public void setRight(boolean isRight) { // boolean은 setisright 아니고 setright된다.
		this.isRight = isRight;
	}

	public boolean isLeft() {
		return isLeft;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("Image/playerR.png");
		playerL = new ImageIcon("Image/playerL.png");
	}

	private void initSetting() {
		x = 70;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // 내부적으로 paintcomponent호출해줌 //상태 변경이 일어나면, 그림을 다시 그려야함

		isRight = false;
		isLeft = false;
	}

	public void left() { // public해야된다. 다른데서 호출가능해야되기 때문에 //방향전환이 되어야한다 > 사진을 바꿔야함 playerL로
		isLeft = true;
		setIcon(playerL); // 얘로 바꿔주면 됨
		System.out.println("왼쪽 이동");

		new Thread(() -> {
			while (isLeft) {
				x = x - 10;
				setLocation(x, y);
				// 위치값을 갖고 paintComponent하는 중
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void right() {
		isRight = true; // 오른쪽 버튼을 떼는 순간(release)까지 true
		setIcon(playerR);
		System.out.println("오른쪽 이동");

		new Thread(() -> { // 새로운 스레드가 main스레드 대신 이 일 한다 -> 메인스레드는 이제 안바빠 -> 호ㅏ면 안뻗어
			while (isRight) {
				x = x + 10; // 본인의 상태를 바꾼것.
				setLocation(x, y);
				try {
					Thread.sleep(10); // thread걸려면 trycatch 걸어줘야해
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
