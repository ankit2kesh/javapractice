@FunctionalInterface
interface TestFunctionalInterface {
	void square(int a);
}

public class FunctionalInterfaceExample {

	public static void main(String[] args) {
		TestFunctionalInterface tf = (a) -> System.out.println(a * a);
		tf.square(5);

	}

}
