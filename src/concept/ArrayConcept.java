package concept;

import java.util.Scanner;


public class ArrayConcept {
	int mango; // class variable gets initialized by default constructor;
	Employee obj[];

	void fun() {
		
		obj = new Employee[1];
		
		Scanner sc = new Scanner(System.in);
		
		for(int cnt = 0; cnt<obj.length; cnt++) {
			System.out.println("Please input values of employee(id, name, salary");
			obj[cnt] = new Employee(sc.nextInt(),sc.next(),sc.nextDouble());
		}
		
		for(Employee emp : obj) {
			emp.displayEmployee();
		}
		
		
//		int apple; //does not get initialized automatically. 
//		int a =10;
//		int aa[]= {10,20,30,40,50};
//		System.out.println(aa.length); // length is a property? not a function
//		System.out.println(aa[2]++); // prints 30 because it increments post fix; 
//		
//		
//		//For each loop
//		for(int arr : aa) {
//			System.out.println("::" + arr++);
//		}
//		
//		//for loop to go backwards 
//		for(int cnt=aa.length -1; cnt>=0; cnt--) {
//			System.out.println("::" + aa[cnt]);
//
//		}
//		
//		int b[];
//		
//		b = new int[10];
//		
//		b[0] = 90;
//		b[1] = 100;
	}
	
	public Employee searchEmployee(int id) {
		for(Employee emp : obj) {
			if(emp.getEid() == id) {
				System.out.println("Employee found");
				return emp;
			}
		}
		return null;
	}
	
	public static void main(String s[]) {
		ArrayConcept ac = new ArrayConcept();
		ac.fun(); //single line/use instance declaration 
		
		Employee searchedEmployee = ac.searchEmployee(1);
		
		if(searchedEmployee != null) {
			System.out.println("Employee Exsist ...");
			searchedEmployee.setEsalary(searchedEmployee.getEsalary() + 5000);
			searchedEmployee.displayEmployee();
		}else {
			System.out.println("Employee does not exist for given id...");
		}
	}
}
