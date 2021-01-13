package console_apps;
import java.util.Scanner;

/*
 * This is version one of a console application.
 * We will prompt the use of radius values of two circles.
 * This application will output the areas of two input circles.
 */
public class CircleApp1 {
	// main method: Entry point of execution.
	public static void main(String[] args) {
		// Starting the execution of the application.
		Scanner input = new Scanner(System.in);
		//Start of application code
		//First Circle
		System.out.println("Enter a radius for the first circle: ");
		double radius1 = input.nextDouble();
		double area1 = radius1*radius1*3.14;
		String area1s = String.format("%.2f", area1);
		System.out.println("Area OF Circle is: "+area1s);
		//Second Circle
		System.out.println("Enter a radius for the second circle: ");
		double radius2 = input.nextDouble();
		double area2 = radius2*radius2*3.14;
		String area2s = String.format("%.2f", area2);
		System.out.println("Area OF Circle is: "+area2s);
		//End Of Application Code
		input.close();
	}

}
