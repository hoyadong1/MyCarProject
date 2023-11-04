package mycar;

public interface Factory <T extends Manageable>{
	public T create();
}
