package console_apps;
import java.util.Scanner;

import model.Circle;

/*
 * This is version one of a console application.
 * We will prompt the use of radius values of two circles.
 * This application will output the areas of two input circles.
 * This version improves version 1 by calling a utility method
 */
public class CircleApp2 {
	// main method: Entry point of execution.
	public static void main(String[] args) {
		// Starting the execution of the application.
		Scanner input = new Scanner(System.in);
		//Start of application code
		//First Circle
		System.out.println("Enter a radius for the first circle: ");
		double radius1 = input.nextDouble();
		double area1 = Circle.getArea(radius1);
		String area1s = String.format("%.2f", area1);
		System.out.println("Area OF Circle is: "+area1s);
		
		//Second Circle
		System.out.println("Enter a radius for the second circle: ");
		double radius2 = input.nextDouble();
		double area2 = Circle.getArea(radius2);
		String area2s = String.format("%.2f", area2);
		System.out.println("Area OF Circle is: "+area2s);
		//End Of Application Code
		input.close();
	}

}
