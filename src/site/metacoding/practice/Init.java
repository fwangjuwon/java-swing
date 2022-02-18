package site.metacoding.practice;

/**
 * 
 * @author 황주원 ---> 생성자 실행 순서 initObject 1번실행 initSetting 2번실행 initListener 3번
 *         실행(default)
 * 
 */

public interface Init {

	void initObject();

	void initSetting();

	default void initListener() {
	}; // 디폴트 붙여놔서, 하고 싶은거만 over ride시키면 됨 (어댑터패턴 대신쓰는거임), 강제성이 무조건 부여되진 않음.

}
