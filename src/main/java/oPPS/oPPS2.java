package oPPS;

public class oPPS2 {

	public static void main(String[] args) {

		person p = new person();
		p.age = 14;
		p.name = "ramji";
		child c = new child();
		c.car();
	}

}

class child extends parent{
	
}
class parent{
	String name;
	int age;
	
void car() {
		System.out.println("my car");
	}
}



