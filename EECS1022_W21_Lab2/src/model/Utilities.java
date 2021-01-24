package model;

public class Utilities {
	/*
	 * Input parameters:
	 * 	- `status` is the filing status (which should be 1 for Single Filing or 2 for Married Filing)
	 *  - `income` is the tax payer's income (an integer value)
	 *  
	 * Assumptions:
	 * 	- `income` passed by user is always positive (> 0)
	 *  
	 * Refer to you lab instructions for what the method should return.
	 * 
	 * See this short tutorial video illustrating how to compute tax:
	 * https://www.youtube.com/watch?v=q2NT5x77hdg&list=PL5dxAmCmjv_7YgI2LgcwjWTHiNZSR-aQX&index=1 
	 */
	public static String getTaxReport(int status, int income) {
		String result = "";
		if (status!=1 && status!=2)
		{
			result = "Illegal Status: "+status;
		}
		else if (status == 1){
			if (income<=8350) {
				String p = String.format("%.2f",(0.1*income));
				result = "Single Filing: $"+p+" (Part I: $"+p+")";
			}
			else if (income>8350 && income<=33950) {
				income = income - 8350;
				double total = 835+(0.15*income);
				String p = String.format("%.2f",(0.15*income));
				String t = String.format("%.2f",total);
				result = "Single Filing: $"+t+" (Part I: $835.00, Part II: $"+p+")";
			}
			else if (income>33950) {
				income = income - 33950;
				double total = 4675+(0.25*income);
				String p = String.format("%.2f",(0.25*income));
				String t = String.format("%.2f",total);
				result = "Single Filing: $"+t+" (Part I: $835.00, Part II: $3840.00, Part III: $"+p+")";
			}
		}
		else if (status==2) {
			if (income<=16700) {
				String p = String.format("%.2f",(0.1*income));
				result = "Married Filing: $"+p+" (Part I: $"+p+")";
			}
			else if (income>16700 && income<=67900) {
				income = income - 16700;
				double total = 1670+(0.15*income);
				String p = String.format("%.2f",(0.15*income));
				String t = String.format("%.2f",total);
				result = "Married Filing: $"+t+" (Part I: $1670.00, Part II: $"+p+")";
			}
			else if (income>67900) {
				income = income - 67900;
				double total = 9350+(0.25*income);
				String p = String.format("%.2f",(0.25*income));
				String t = String.format("%.2f",total);
				result = "Married Filing: $"+t+" (Part I: $1670.00, Part II: $7680.00, Part III: $"+p+")";
			}
		}
		/* Your implementation of this method starts here. 
		 * Recall from Week 1's tutorial videos:
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, an explicit, final `return` statement is placed for you.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
		
		

		/* Your implementation ends here. */

		return result;
	}
	
	public static String getRPSGameReport(String p1, String p2, char p1r1, char p2r1, char p1r2, char p2r2) {
		String result = "";
		int score = 0;
		String R1 ="";
		String R2 ="";
//		Round 1
		int r1 = rounds(p1r1, p2r1);
		if (r1==1) {
			R1 = "[Round 1: "+p1+" wins ("+p1r1+" vs. "+p2r1+") ; ";
			score++;
		}
		else if (r1==2) {
			R1 = "[Round 1: "+p2+" wins ("+p2r1+" vs. "+p1r1+") ; ";
			score--;
		}
		else if (r1==0) {
			R1 = "[Round 1: Tie ("+p2r1+" vs. "+p1r1+") ; ";
		}
//		Round 2
		int r2 = rounds(p1r2, p2r2);
		if (r2==1) {
			R2 = "Round 2: "+p1+" wins ("+p1r2+" vs. "+p2r2+")]";
			score++;
		}
		else if (r2==2) {
			R2 = "Round 2: "+p2+" wins ("+p2r2+" vs. "+p1r2+")]";
			score--;
		}
		else if (r2==0) {
			R2 = "Round 2: Tie ("+p2r2+" vs. "+p1r2+")]";
		}
//		score check
		if(score == 0) {
			result = "Game over: Tie! "+R1+R2;
		}
		else if(score>0) {
			result = "Game over: "+p1+" wins! "+R1+R2;
		}
		else if(score<0) {
			result = "Game over: "+p2+" wins! "+R1+R2;
		}
		return result;
	}
	
	public static int rounds(char a,char b) {
		int r = 000; 
		if (a=='R' && b=='R')
			r = 0;
		if (a=='R' && b=='P')
			r = 2;
		if (a=='R' && b=='S')
			r = 1;
		if (a=='P' && b=='R')
			r = 1;
		if (a=='P' && b=='P')
			r = 0;
		if (a=='P' && b=='S')
			r = 2;
		if (a=='S' && b=='R')
			r = 2;
		if (a=='S' && b=='P')
			r = 1;
		if (a=='S' && b=='S')
			r = 0;
		return r;
	}
}
