package concept;

class Employee{
	private int eid;
	private String ename;
	public double getEsalary() {
		return esalary;
	}
	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}

	private double esalary;
	
	public int getEid() {
		return eid;
	}
	public Employee(int eid, String ename, double esalary) {
		this.eid=eid;
		this.ename=ename;
		this.esalary = esalary;
	}
	
	public void displayEmployee() {
		System.out.println(eid + ename + esalary);
		System.out.println();//syso + ctrl space
	}
	
	
}
