package site.metacoding.ex13.enumerate;

// 인터페이스의 변수는 public static final 이 생략되어 있다.
interface Direction {
	String LEFT = "Left";
	String RIGHT = "Right";
}

public class EnumEx01 {

	public static void add(String direction) {
		// 무조건 "Left", "Right"
		if (direction.equals("Left") || direction.equals("Right")){
			System.out.println("잘 들어왔군.");
		} else {
			System.out.println("너 잘못 입력했어.");
		}
	}
	
	public static void main(String[] args) {
		add(Direction.RIGHT);
	}
	
}
