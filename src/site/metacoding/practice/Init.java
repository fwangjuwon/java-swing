package site.metacoding.practice;

/**
 * 
 * @author Ȳ�ֿ� ---> ������ ���� ���� initObject 1������ initSetting 2������ initListener 3��
 *         ����(default)
 * 
 */

public interface Init {

	void initObject();

	void initSetting();

	default void initListener() {
	}; // ����Ʈ �ٿ�����, �ϰ� �����Ÿ� over ride��Ű�� �� (��������� ��ž��°���), �������� ������ �ο����� ����.

}
