package oPPS;

public class OPPS {

	public static void main(String[] args) {

		person p1 = new person(); //creating an object
		p1.age = 24;  //assigning argument
		p1.name = "Aman";
//		p1.eat();  //calling method with object
		p1.walk();
		Info(); //calling without object because of static method
		person p2 = new person("33", "raju");
		p2.eat("raman");
	}
	
	public static void Info() {
		System.out.println("information");
	}

}

class person{
	String name;
	int age;
	
	 void person(int age, String name) {
		this.age = age;
	}

	
	void eat(String name){
		System.out.println(name + " "+"is eating");
		name = this.name;	
	}
	void walk() {
		System.out.println(name + " "+"is walking");
	}
	
}






