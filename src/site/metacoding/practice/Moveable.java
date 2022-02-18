package site.metacoding.practice;

public interface Moveable {
	void left();

	void right();

	void up();

	default void down() {

	};
}
