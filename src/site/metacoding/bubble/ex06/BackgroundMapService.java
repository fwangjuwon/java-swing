package site.metacoding.bubble.ex06;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

//백그라운드 서비스: 눈에 안보이지만, 플레이어의 움직임을 계속 주시하면서 부딪히는 것을 실시간으로 체크한다 -> 독립적인 스레드로 돌려야한다 (메인스레드로 돌리면 프로그램안돌아간다)
public class BackgroundMapService implements Runnable {

	// 의존해야하는 애들을 composition(결합)해야된다. 생성자에서 받아야한다. -> 플레이어!
	private Player player;
	private BufferedImage image;// 버퍼를 이미지로 읽는다는 것: 0,1로 읽는 것

	// composition한 애들을 생성자에서 받아야한다. 컴포지션을 위한 기술: 의존성 주입(생성자를 통해서 주입하는것) -> DI
	// (Dependency Injection)
	public BackgroundMapService(Player player) {
		this.player = player;
		try {
			// raw 하게 읽는다=날것그대로 읽는다.
			image = ImageIO.read(new File("Image/test.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() { // background service!! 따로 서비스로 돌리는거니까 ㅎㅎ
		// 색상 계산(while) -> main이 돌리면 절대 안돼! -> implement 해서 run에 넣어
		while (true) {
			try {
				Color color = new Color(image.getRGB(player.getX() + 50, player.getY()));
				System.out.println(color.getRed());
				System.out.println(color.getGreen());
				System.out.println(color.getBlue());
				System.out.println("==================");
				Thread.sleep(10); // 충돌방지를 미세하게 하는 조절!
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
