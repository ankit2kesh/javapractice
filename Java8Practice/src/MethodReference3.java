@FunctionalInterface
interface Messageable {
	int display(String msg);

}

public class MethodReference3 {
	int demo(String str) {
		return str.length();
	}

	public static void main(String[] args) {
		MethodReference3 m = new MethodReference3();
		Messageable m1 = m::demo;
		m1.display("Hello");

		 System.out.println(m1.display("Hello"));

	}
}