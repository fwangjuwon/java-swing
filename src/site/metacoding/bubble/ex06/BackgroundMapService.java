package site.metacoding.bubble.ex06;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

//��׶��� ����: ���� �Ⱥ�������, �÷��̾��� �������� ��� �ֽ��ϸ鼭 �ε����� ���� �ǽð����� üũ�Ѵ� -> �������� ������� �������Ѵ� (���ν������ ������ ���α׷��ȵ��ư���)
public class BackgroundMapService implements Runnable {

	// �����ؾ��ϴ� �ֵ��� composition(����)�ؾߵȴ�. �����ڿ��� �޾ƾ��Ѵ�. -> �÷��̾�!
	private Player player;
	private BufferedImage image;// ���۸� �̹����� �д´ٴ� ��: 0,1�� �д� ��

	// composition�� �ֵ��� �����ڿ��� �޾ƾ��Ѵ�. ���������� ���� ���: ������ ����(�����ڸ� ���ؼ� �����ϴ°�) -> DI
	// (Dependency Injection)
	public BackgroundMapService(Player player) {
		this.player = player;
		try {
			// raw �ϰ� �д´�=���ͱ״�� �д´�.
			image = ImageIO.read(new File("Image/test.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() { // background service!! ���� ���񽺷� �����°Ŵϱ� ����
		// ���� ���(while) -> main�� ������ ���� �ȵ�! -> implement �ؼ� run�� �־�
		while (true) {
			try {
				Color color = new Color(image.getRGB(player.getX() + 50, player.getY()));
				System.out.println(color.getRed());
				System.out.println(color.getGreen());
				System.out.println(color.getBlue());
				System.out.println("==================");
				Thread.sleep(10); // �浹������ �̼��ϰ� �ϴ� ����!
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
