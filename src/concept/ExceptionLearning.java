package concept;

import java.util.InputMismatchException;
import java.util.Scanner;

class Calculator{
	public int calculate(int fno, int sno, String operator) throws NumberNegativeException{
		if (fno < 0 || sno < 0) {
			throw new NumberNegativeException(); //caled functions throws exception to the calling function (main in this case).
		}
		int answer =0;
		switch (operator) {
		case "+":
			answer = sno + fno;
			break;
		case "-":
			answer = fno + sno;
			break;
		case "/":
			answer = fno + sno;
			break;
		case "*":
			answer = sno * fno;
			break;
		case "%":
			answer = sno % fno;
			break;

		default:
			break;
		}
		return answer;
	}
}
public class ExceptionLearning {

	public static void main(String s[]) {
		
		try {
			System.out.println("Enter first number second number plus operator");

			Scanner sc = new Scanner(System.in);
			int fno = sc.nextInt();
			int sno = sc.nextInt();
			System.out.println("Enter operator");
			String operator = sc.next();
			
			Calculator objCalculator = new Calculator();
			int answer = objCalculator.calculate(fno, sno, operator);
			
			System.out.println(sno + " " + operator + " " + sno + " = " + answer);
		}catch (ArithmeticException ex) {

		}
		catch (InputMismatchException in) {
			
		}catch (NumberNegativeException e) {
			System.out.println(e.getErrorMesssage());
			
		}
		catch (Exception e) {
			e.printStackTrace();
		System.out.println("name of exception: " + e.getClass().getName());
		}
		finally {
			System.out.println("thank you");
			
//			finally wont run if you use this
//			System.exit(0);
		}

	}
}
