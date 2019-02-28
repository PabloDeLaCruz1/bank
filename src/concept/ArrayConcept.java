package concept;

public class ArrayConcept {
	int mango; // class variable gets initialized by default constructor;

	void fun() {
		int apple; //does not get initialized automatically. 
		int a =10;
		int aa[]= {10,20,30,40,50};
		System.out.println(aa.length); // length is a property? not a function
		System.out.println(aa[2]++); // prints 30 because it increments post fix; 
		
		for(int arr : aa) {

			System.out.println("::" + arr++);
		}
		
		int b[];
		
		b = new int[10];
		
		b[0] = 90;
		b[1] = 100;
	}
	
	public static void main(String s[]) {
		new ArrayConcept().fun(); //single line/use instance declaration 
		
	}
}
