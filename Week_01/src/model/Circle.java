package model;

public class Circle {
	/*
	 * Utility Method: not requiring the creation of a object in order to use them.
	 */
	public static double getArea(double radius) {
		double area = 0.0;
		area = radius*radius*3.14;
//		area = 2*3.14*radius;
		return area;
	}
}
