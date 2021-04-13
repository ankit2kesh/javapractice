@FunctionalInterface
interface TestInterface {
	void square(int a);

	default void show() {
		System.out.println("parent method executed");
	}
	
	static void show1() {
		System.out.println("parent method executed");
	}
}

public class InterfaceExample implements TestInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestInterface ie = new InterfaceExample();
		ie.square(4);
		ie.show();
	}

	public void show() {
		System.out.println("child method executed");
	}
	
	static void show1() {
		System.out.println("child method executed");
	}

	@Override
	public void square(int a) {
		System.out.println(a * a);
	}

}
