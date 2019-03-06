package concept;

public class StringConcepts {
	public enum Color {WHITE, BLACK, RED, YELLOW, BLUE};


	public void fun() {
//		StringBuilder str = new StringBuilder("Hello...");
//		str.append("World");
//		System.out.println(str);
		
//		String str = "Hello...";
//		String str1 = "Hello...";
//		System.out.println(str.hashCode());
//		System.out.println(str1.hashCode());


	}
	public static void main(String[] s) {
//		new StringConcepts().fun();
		
		StringBuilder stringBuilder = new StringBuilder();//not sync, not thread safe
		StringBuffer stringBuffer = new StringBuffer(); //sync and thread safe
//
		stringBuilder.append("hello 1 2 3 4 444 555");
		
		stringBuffer.append("hello 1 2 3 4 444 555");
		
//		System.out.println(stringBuffer);
//		System.out.println(stringBuilder);
		
//		String aName = "Syntel";
//		String bName="Syntel"; 
//		if (aName.equals(bName)){
//			System.out.println("True"); 
//		}else {
//			System.out.println("False");
//		} 

		System.out.println(Color.RED);
	}
}
