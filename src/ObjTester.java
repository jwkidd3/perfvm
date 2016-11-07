
public class ObjTester {

	public static void main(String[] args) {

		BubbasCousin bc = new BubbasCousin();
		
	}

}

class Bubba extends Object{
	public Bubba() {
		System.out.println("Bubba was created....");
	}
}

class BubbasCousin extends Bubba {
	public BubbasCousin() {
		System.out.println("Bubbas cousin created");
	}
}
