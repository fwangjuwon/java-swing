package site.metacoding.bubble.ex02;

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

	public Player() {
		initObject();
		initSetting();
	}

	private void initObject() {
		playerR = new ImageIcon("Image/playerR.png");
	}

	private void initSetting() {
		x = 70;
		y = 535;
		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y); // 내부적으로 paintcomponent호출해줌 //상태 변경이 일어나면, 그림을 다시 그려야함

	}
}
