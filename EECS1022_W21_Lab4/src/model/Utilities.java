package model;
/*
 * Requirements:
 * - Any use of Java library classes or methods (e.g., ArrayList) is forbidden.
 * 	 (That is, there must not be an import statement in the beginning of this class.)
 * Violation of this requirement will result in a 50% penalty of your marks.
 *  
 * - Use only if-statements and/or loops to manipulate primitive arrays (e.g., int[], String[]).
 */

public class Utilities {
	public static int[] getMultiplesOf3(int[] numbers) {
		int[] result = {};
		int ctr = 0;
		for (int i = 0;i<numbers.length;i++)
		{
			if (numbers[i]%3==0) {
				ctr++;
			}
		}
		int c = 0;
		result = new int[ctr]; 
		for (int i = 0;i<numbers.length;i++)
		{
			if (numbers[i]%3==0)
			{				
				result[c] = numbers[i];
				c++;
			}
		}
		return result;
	}	
	
	public static int[] getFilteredSeq(int[] numbers, int n) {
		int[] result = {};
		int ctr = 0;
		for (int i = 0;i<numbers.length;i++)
		{
			if (numbers[i]!=n) {
				ctr++;
			}
		}
		result = new int[ctr]; 
		for (int i = 0,c=0;i<numbers.length;i++)
		{
			if (numbers[i]!=n)
			{				
				result[c] = numbers[i];
				c++;
			}
		}
		return result;
	}
	
	public static String[] getAllPrefixes(int[] numbers) {
		String[] result;
		result = new String[numbers.length];
		for(int i = 0;i<result.length;i++) {
			String ele = "[";
			for(int j=0;j<=i;j++) {
				ele = ele + numbers[j]+", ";
			}
			ele = ele.substring(0, ele.length()-2);
			ele = ele +"]";
			result[i] = ele;
		}
		return result;
	}
	
	/*
	 * Input parameters:
	 * 	- `numbers` : an array of integers
	 *  
	 * Refer to you lab instructions for what the method should return. 
	 */
	public static int[] getGroupedNumbers(int[] numbers) {
		int[] result = new int[numbers.length];
		int ctr=0;
		for (int i = 0;i<numbers.length;i++)
		{
			if(numbers[i]%3==0) {
				result[ctr]=numbers[i];
				ctr++;
			}
		}
		for (int i = 0;i<numbers.length;i++)
		{
			if(numbers[i]%3==1) {
				result[ctr]=numbers[i];
				ctr++;
			}
		}
		for (int i = 0;i<numbers.length;i++)
		{
			if(numbers[i]%3==2) {
				result[ctr]=numbers[i];
				ctr++;
			}
		}
		return result;
	}
}
