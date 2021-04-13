/*interface FourWheeler {

 

   default void print() {
      System.out.println("I am a four wheeler!");
   }
}

 


}*/

class Vehicle {
	static void blowHorn() {
		System.out.println("Blowing horn!!!");
	}
}

class Car extends Vehicle {

	public static void blowHorn() {
		/*
		 * Vehicle.super.print(); FourWheeler.super.print(); Vehicle.blowHorn();
		 */
		System.out.println("I am a car!");
	}
}

public class INterfaceDemo {

	public static void main(String args[]) {
		Vehicle vehicle = new Car();// upcasting
		Car car = new Car();
		vehicle.blowHorn();
	}
}