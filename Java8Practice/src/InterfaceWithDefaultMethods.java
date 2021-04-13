interface A{
	void save();
}
interface B{
	default void save() {System.out.println("default");}
}
public class InterfaceWithDefaultMethods implements A,B {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		B.super.save();
	}
	public static void main(String[] args) {
		InterfaceWithDefaultMethods x=new InterfaceWithDefaultMethods();
		x.save();
	}

}
