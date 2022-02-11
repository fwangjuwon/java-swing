package site.metacoding.practice;

interface Knife {
	void attack();

	void cook();
}

abstract class 요리사어댑터 implements Knife { // 백종원에 대한 추상화, 추상메서드는 오버라이드를 구현하지 않아도 된다. 그냥 비워두는거야. attack을 걸러낸거지 .
	@Override
	public void attack() {
	}
}

abstract class 싸움꾼어댑터 implements Knife { // 검투사에 대한 추상화
	@Override
	public void cook() {
	}
}

class 백종원 extends 요리사어댑터 {

	@Override
	public void cook() {
		// TODO Auto-generated method stub

	}

//	@Override
//	public void attack() { // 사용 안함 , implement걸면  안쓰는걸 구현하고 있으니까 시룬고얌 -> 인터페이스를 갈아엎어야되 근데 그게 쉽지 않앙 추상클래스를 만들어서 오버라이드를 걸러내고 extends시키자.(어댑터패턴)-> 이걸 요즘 잘 안쓰는데 이유가 interface default가 생겨서 그걸 많이 써 그럼 강제성이 사라져 
//	}
//
//	@Override
//	public void cook() {
//		System.out.println("요리중");
//	}
}

class 검투사 extends 싸움꾼어댑터 {
	@Override
	public void attack() {
		// TODO Auto-generated method stub

	}
}

public class PatternTest {
	// 어댑터 패턴

}
