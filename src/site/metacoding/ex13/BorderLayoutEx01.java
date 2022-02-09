package site.metacoding.ex13;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import site.metacoding.ex13.constant.BorderConstant;

public class BorderLayoutEx01 extends MyFrame {

	public BorderLayoutEx01() {
		 super(500, 500);
		 
		 JPanel panel = (JPanel) getContentPane();
		 panel.setLayout(new BorderLayout()); // 생략가능!! 디폴트가 BorderLayout 이니까!!
		
		 JButton btnNorth = new JButton("북쪽");
		 JButton btnEast = new JButton("동쪽");
		 JButton btnWest = new JButton("서쪽");
		 JButton btnSouth = new JButton("남쪽");
		 JButton btnCenter = new JButton("가운데");
		 
//		 panel.add(btnNorth, BorderConstant.NORTH);
//		 panel.add(btnEast, BorderConstant.EAST);
//		 panel.add(btnWest, BorderConstant.WEST);
//		 panel.add(btnSouth, BorderConstant.SOUTH);
//		 panel.add(btnCenter, BorderConstant.CENTER);
		 
		 panel.add(btnNorth, BorderLayout.NORTH);
		 // panel.add(btnEast, BorderLayout.EAST);
		 panel.add(btnWest, BorderLayout.WEST);
		 // panel.add(btnSouth, BorderLayout.SOUTH);
		 panel.add(btnCenter, BorderLayout.CENTER);
		 
		setVisible(true); // paint 메서드 (그림 그리기)
	}
	
	public static void main(String[] args) {
		new BorderLayoutEx01();
	}

}
