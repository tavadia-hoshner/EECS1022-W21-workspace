package model;
public class Utilities
{
	/* 
	 * 	Requirements:
	 * 	- It is strictly forbidden for you to use: 
	 * 		+ Any Java library method (e.g., Arrays.sort)
	 * 		  (That is, there must not be an import statement in the beginning of this class.)
	 * 		+ arrays
	 * 	- You will receive an immediate zero for this task if the requirement is violated. 
	 * 
	 * Only write lines of code within the methods given to you.
	 * Do not add any new helper methods. 
	 * Do not declare any variables OUTSIDE the given methods.
	 * You can only declare local variables within each method.
	 * 
	 * Your submission will only be graded against:
	 * 	- JUnit tests given to you in TestUtilities
	 * 	- additional JUnit tests 
	 * 	  (therefore it is important that you test your own methods
	 *     by either the console application class App or your own JUnit tests) 
	 */

	//	Task 1.
	 
	public static String getBMIReport(String unitOfWeight, double valueOfWeight, String unitOfHeight, double valueOfHeight) {
		String result = "";
		int flag = 0;
		double weight;
		double height;
		if (unitOfWeight!="pound" && unitOfWeight!="kilogram") {
			result = "Error: "+unitOfWeight+" is not a valid weight unit";flag++;}
		else if (unitOfHeight!="inch" && unitOfHeight!="foot") {
			result = "Error: "+unitOfHeight+" is not a valid height unit";flag++;}
		else if (valueOfWeight<=0.0 || valueOfHeight<=0.0) {
			result = "Error: both weight and height must be positive";flag++;}
		
		if (unitOfHeight.equals("inch")) 
		{
				height=valueOfHeight*0.0254;
		}
		else 
		{
			height=valueOfHeight*0.3048;
		}
		if (unitOfWeight.equals("pound"))
		{	
			weight = valueOfWeight*0.453592;
		}
		else 
		{
			weight = valueOfWeight;
		}
		double bmi = weight/(Math.pow(height, 2));
		
		if (flag==0) 
		{
			result = "BMI is: "+String.format("%.2f", bmi);
			if (bmi<18.5) 
				result = result+" (Underweight)";
			else if (bmi>=18.5 && bmi<25.0)
				result = result+" (Normal)";
			else if (bmi>=25.0 && bmi<30.0)
				result = result+" (Overweight)";
			else
				result = result+" (Obese)";
		}
		 
		return result;
	}
	
//		Task 2.

	public static String getLargestTwoNumbers(int n1, int n2, int n3, int n4) {
		String result = "";
		int m,n;
		int max1;
		int max2;
		max1 = Math.max(n1, n2);
		max2 = Math.max(n3, n4);
		m = Math.max(max1, max2);
		if (m==n1)
				n1=n2;
		else if (m==n2)
				n2=n1;
		else if (m==n3)
			n3=n4;
		else
			n4=n3;
		max1 = Math.max(n1, n2);
		max2 = Math.max(n3, n4);
		n = Math.max(max1, max2);
		result = "largest is "+m+" and second largest is "+n;
		return result;
	}
	
//		Task 3.
	 
	public static String getWinnerOfRPS(String p1, char p1Option, String p2, char p2Option) {
    	String result = "";
    	if (p1Option=='r' && p2Option=='r')
    		result = "tie";
    	else if (p1Option=='r' && p2Option=='p')
    		result = p2;
		else if (p1Option=='r' && p2Option=='s')
			result = p1;
		else if (p1Option=='p' && p2Option=='r')
			result = p1;
		else if (p1Option=='p' && p2Option=='p')
			result = "tie";
		else if (p1Option=='p' && p2Option=='s')
			result = p2;
		else if (p1Option=='s' && p2Option=='r')
			result = p2;
		else if (p1Option=='s' && p2Option=='p')
			result = p1;
		else if (p1Option=='s' && p2Option=='s')
			result = "tie";
    	
        return result;
    }
}

