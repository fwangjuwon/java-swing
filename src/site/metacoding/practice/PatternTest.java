package site.metacoding.practice;

interface Knife {
	void attack();

	void cook();
}

abstract class �丮������ implements Knife { // �������� ���� �߻�ȭ, �߻�޼���� �������̵带 �������� �ʾƵ� �ȴ�. �׳� ����δ°ž�. attack�� �ɷ������� .
	@Override
	public void attack() {
	}
}

abstract class �ο�۾���� implements Knife { // �����翡 ���� �߻�ȭ
	@Override
	public void cook() {
	}
}

class ������ extends �丮������ {

	@Override
	public void cook() {
		// TODO Auto-generated method stub

	}

//	@Override
//	public void attack() { // ��� ���� , implement�ɸ�  �Ⱦ��°� �����ϰ� �����ϱ� �÷��� -> �������̽��� ���ƾ���ߵ� �ٵ� �װ� ���� �ʾ� �߻�Ŭ������ ���� �������̵带 �ɷ����� extends��Ű��.(���������)-> �̰� ���� �� �Ⱦ��µ� ������ interface default�� ���ܼ� �װ� ���� �� �׷� �������� ����� 
//	}
//
//	@Override
//	public void cook() {
//		System.out.println("�丮��");
//	}
}

class ������ extends �ο�۾���� {
	@Override
	public void attack() {
		// TODO Auto-generated method stub

	}
}

public class PatternTest {
	// ����� ����

}
