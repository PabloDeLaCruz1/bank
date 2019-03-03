package ds;

import java.util.*; //collection in this package

class Employee {
	private int eid;

	public int getEid() {
		return eid;
	}

	public String getEfname() {
		return efname;
	}

	public String getElname() {
		return elname;
	}

	private String efname;
	private String elname;
	public double getEsalary() {
		return esalary;
	}

	private double esalary;

	public Employee(int eid, String efname, String elname, double esalary) {
		this.eid = eid;
		this.efname = efname;
		this.elname = elname;

		this.esalary = esalary;
	}

	public void displayEmployee() {
		System.out.println(eid + " " + efname + " " + elname + " " + esalary);
	}

}

public class CollectionConcept {
	Map<String, Employee> eMap = new HashMap<String, Employee>();

	void fun() {
		// int a =10;
		// float b = 10f;
		// double c = 30.30;
		//// String d = "Hello I am string.";
		//// double mango = 30.30;
		//
		//
		// Set set = new HashSet(); //interface pointing to class
		// set.add(a); //allows primitive type because of AUTOBOXING
		// set.add(b);
		// set.add(c);
		// set.add(d);
		// set.add(mango);
		//
		// System.out.println(set); // Set is UNORDERED set of UNIQUE values
		//
		// for(Object ob : set) {
		// System.out.println(ob.getClass().getName());
		// if (ob.getClass().getName().toString().equals("java.lang.Integer")) { //this
		// is called REFLECTION
		//
		// System.out.println((Integer)ob+100);
		// }
		// }

		// -----------//
		// GENERICS in collection, used to tell our collection to store a data type
		// Set<Integer> set = new HashSet(); //Here we are creating a contract with Set
		// by declaring we require Integers
		//
		// set.add(10);
		// set.add(20);
		// set.add(30);
		// set.add(40);
		//
		// for(Integer ob: set) {
		// System.out.println()ob + 100);
		// }
		//
		// ----------------------------------//
		// List

		// List<Integer> set = new ArrayList<Integer>(); //Ordered set of values (allows
		// duplicates).
		//
		// set.add(10);
		// set.add(20);
		// set.add(30);
		// set.add(40);
		//
		// for(Integer ob: set) {
		// System.out.println(ob + 100);
		// }
		// set.remove(2);
		//
		// for(Integer ob: set) {
		// System.out.println(ob + 100);
		// }

		// SortedSet<Integer> set = new TreeSet<Integer>(); //No Duplicates, its a kind
		// of set but its sorted. Here again we have interface pointing to class
		//
		// set.add(10);
		// set.add(240);
		// set.add(301);
		// set.add(40);
		// set.add(40);
		// set.add(40);
		//
		//
		// for(Integer ob: set) {
		// System.out.println(ob);
		// }

		// Extra credit learn LL, DLL, etc

		// ------------------------------MAPS--------------------------------------------//

		// Map<String, Integer> map = new HashMap<String,Integer>();
		//
		// map.put("mango", 10); //we use put because map is not a collection.
		// map.put("apple",240);
		// map.put("dsadasd",301);
		// map.put("banana",40);
		// map.put("xx",40);
		// map.put("yy",40);
		//
		// System.out.println(map.get("apple")); //you access the value through the key.
		// Key should always be unique.
		//
		// Set<String> allKeys = map.keySet(); //since key is unique, its a kind of set
		//
		// for(String s : allKeys) {
		// System.out.println(map.get(s));
		// }

	}

	void fun1() {
		Employee obj1 = new Employee(10009, "John", "ABCE", 10000);
		Employee obj2 = new Employee(10019, "John1", "ABCE1", 20000);
		Employee obj3 = new Employee(10029, "John2", "ABCE2", 30000);
		Employee obj4 = new Employee(10039, "John3", "ABCE3", 40000);
		Employee obj5 = new Employee(10049, "John4", "ABCE4", 50000);
		Employee obj6 = new Employee(10059, "John5", "ABCE5", 60000);

		String key = obj1.getEfname().substring(0, 1) + obj1.getElname().substring(0, 1) + obj1.getEid();

		eMap.put(obj1.getEfname().substring(0, 1) + obj1.getElname().substring(0, 1) + obj1.getEid(), obj1);
		eMap.put(obj2.getEfname().substring(0, 1) + obj2.getElname().substring(0, 1) + obj2.getEid(), obj2);
		eMap.put(obj3.getEfname().substring(0, 1) + obj3.getElname().substring(0, 1) + obj3.getEid(), obj3);
		eMap.put(obj4.getEfname().substring(0, 1) + obj4.getElname().substring(0, 1) + obj4.getEid(), obj4);
		eMap.put(obj5.getEfname().substring(0, 1) + obj5.getElname().substring(0, 1) + obj5.getEid(), obj5);
		eMap.put(obj6.getEfname().substring(0, 1) + obj6.getElname().substring(0, 1) + obj6.getEid(), obj6);
		
		
		//Show all employees
		Set<String> allKeys = eMap.keySet();
		Set<String> search = new HashSet<String>();
		for(String k : allKeys) {
			eMap.get(k).displayEmployee();
		}
		
		Set<String> deleteKeys = eMap.keySet();
//		Delete employees
		for(String k : deleteKeys) {
			if(eMap.get(k).getEsalary() < 15000) {
				search.add(k);
			}
		}
		//Show all employees
//		Set<String> allKeys = eMap.keySet();
		for(String k : allKeys) {
			eMap.get(k).displayEmployee();
		}

	}

	public static void main(String[] args) {
		new CollectionConcept().fun();
	}
}
