package concept;

enum colors{RED,GREEN,BLUE,BROWN};
class Test{
	void fun(colors color) {
		switch(color) {
			case RED:
				System.out.println("You entered Red Color");
				break;
			case GREEN:
				System.out.println("You entered Green Color");
				break;
			case BLUE:
				System.out.println("You entered Blue Color");
				break;
			case BROWN:
				System.out.println("You entered Brown Color");
				break;
			default:
				break;
		}
	}
}
public class NewConcept {
		public void check() {
			Test obj = new Test();
			obj.fun(colors.BLUE);
		}

		public static void main(String[] s) {
			new NewConcept().check();
		}
}
