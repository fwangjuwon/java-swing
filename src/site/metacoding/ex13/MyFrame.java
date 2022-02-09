package site.metacoding.ex13;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Ctrl + Shift + F -> 자동 정렬
// Ctrl + Shift + O -> 자동 import
public class MyFrame extends JFrame {
	public MyFrame() {
		super(); // 생략되어 있음.
		System.out.println("MyFrame 디폴트");
		setSize(600, 400); // w, h
		setLocationRelativeTo(null); // 프레임 화면 중앙 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭 시 main 종료 -> 3
	}
	
	
	public MyFrame(int w, int h) {
		super(); // 생략되어 있음.
		System.out.println("MyFrame 오버로딩된 생성자");
		setSize(w, h); // w, h
		setLocationRelativeTo(null); // 프레임 화면 중앙 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 클릭 시 main 종료 -> 3
	}
}