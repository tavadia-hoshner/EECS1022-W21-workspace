package model;

public class Utilities {
	
	public static String getNumbers(int lower, int upper) {
		String result = "";
		if (lower<0 || upper<0)
			result = "Error: both bounds must be non-negative";
		else if (lower>upper)
			result = "Error: lower bound "+lower+" is not less than or equal to upper bound "+upper;
		else {
			String Numbers="";
			int ctr = 1;
			if(lower%3==0)
				Numbers = "<("+lower+")";
			else if(lower%3==1)
				Numbers = "<["+lower+"]";
			else 
				Numbers = "<{"+lower+"}";
			
			for(int i =lower+1;i<=upper;i++) {
				if(i%3==0) {
					Numbers = Numbers+", ("+i+")";
					ctr++;
				}
				else if(i%3==1) {
					Numbers = Numbers+", ["+i+"]";
					ctr++;
				}
				else {
					Numbers = Numbers+", {"+i+"}"; 
					ctr++;
				}
			}
			Numbers = Numbers +">";
			if (ctr>1) 
				result = ctr +" numbers between "+lower+" and "+upper+": "+Numbers;
			else 
				result = "1 number between "+lower+" and "+upper+": "+Numbers;
			return result;
			
		}
		return result;
	}
	
	
	public static String getIntermediateStats(int ft, int d, int n) {
		String result = "{";
		String Numbers = "" ;
		int no = ft;
		int sum = 0;
		for(int i = 0;i<n;i++) {
			no = ft+d*i;
			sum = sum + no;		
			if (i==0)
				Numbers = Numbers+no;
			else
				Numbers = Numbers+", "+no;
			String result1 = "[sum of <"+Numbers+">: "+sum;
			double avg = (double)sum/(i+1);
			String res = String.format("%.2f",(avg));
			result1 = result1 +" ; avg of <"+Numbers+">: "+res+"]";
			if (i!=0)
				result = result + ", "+result1;
			else 
				result = result +result1;			
		}
		result = result+"}";
		return result;
	}
	
	
	public static String getInterlevaings(int ft1, int d1, int n1, int ft2, int d2, int n2) {
		String result = "<";
		int i = 0;
		while (n1>0 || n2>0) {
			if (n1>0) {
				result = result + "("+(ft1+d1*i)+"), ";
				n1--;
			}
			if (n2>0) {
				result = result + "["+(ft2+d2*i)+"], ";
				n2--;
			}
			i++;
		}
		int len = result.length();
		if (len>2)
			result = result.substring(0,result.length()-2)+">";
		else
			result = result+">";
		return result;
	}	
}
