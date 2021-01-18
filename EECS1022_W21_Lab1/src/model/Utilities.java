package model;

public class Utilities {
	
	/*
	 * Assumption: the return geometric sequence is of a fixed size 5. 
	 * Therefore, it is not necessary to solve this problem using a loop,
	 * or to use methods from a library class (e.g., Math).\
	 * 
	 * Input parameters:
	 * 	- `ft` is the first term in the sequence
	 *  - `ratio` is the common rations among terms in the sequence
	 *  
	 * Refer to you lab instructions for what the method should return.
	 */
	public static String getGeometricSequence(int ft, int ratio) {
		String result = "";
		double avg = (ft+ft*ratio+ft*ratio*ratio+ft*ratio*ratio*ratio+ft*ratio*ratio*ratio*ratio)/5.0;
		result = "["+ft+"]" +"["+ft*ratio+"]" +"["+ft*ratio*ratio+"]" +"["+ft*ratio*ratio*ratio+"]" +"["+ft*ratio*ratio*ratio*ratio+"]" + " has average "+avg;
		
		return result;
	}
	
	/*
	 * Input parameters:
	 *   - `weight` is the user's weight in pounds
	 *   - `height` is the user's height in inches
	 *   
	 * Refer to you lab instructions for what the method should return. 
	 */
	public static double getBMI(double weight, double height) {
		double result = 0.0;
		
		weight = weight *0.4536;
		height = height*0.0254;
		result = weight/(height*height);
		
		return result;
	}
	
	/*
	 * Assumption: input value `seconds` is non-negative (i.e., >= 0).
	 * 
	 * Input parameters:
	 *   - `seconds` is the number of seconds to be converted
	 *   
	 * Refer to you lab instructions for what the method should return.
	 */
	public static String getTimeConversion(int seconds) {
		String result = "";
		
		int days = seconds/(60*60*24);
		seconds = seconds%(60*60*24);
		int hours = seconds/(60*60);
		seconds = seconds%(60*60);
		int mins = seconds/(60);
		int sec = seconds%60;
		result = days+" days "+hours+" hours "+mins+" minutes "+sec+" seconds";
		return result;
	}
}
