package model;

public class Registration {
//	CLASS VARIABLES
	private String Title;
	private int marks = 0;
	private Instructor prof = null;
	private String[] report = {"F","Failing"};
	private int grade;
	
//	CONSTRUCTORS
	public Registration(String title, int m, Instructor p)
	{
		this.Title=title;
		this.marks=m;
		this.prof=p;
	}
	
	public Registration(String title, Instructor p)
	{
		this.Title=title;
		this.prof=p;
	}
	
	public Registration(String title, int m)
	{
		this.Title=title;
		this.marks=m;
	}
	
	public Registration(String title)
	{
		this.Title=title;
	}
	
//	CLASS METHODS (GETTERS)
	public String getTitle()
	{
		return this.Title;
	}
	
	public int getGrade()
	{
		return this.grade;
	}
	
	public int getMarks()
	{
		return this.marks;
	}
	
	public Instructor getInstructor()
	{
		return this.prof;
	}
	
	public String[] getGradeReport() 
	{
		String grade = "";
		String disc = "";
		if (this.marks>=90) 
		{
			grade = "A+";
			disc = "Exceptional";
		}
		else if (this.marks<90 && this.marks>=80) 
		{
			grade = "A";
			disc = "Excellent";
		}
		else if (this.marks<80 && this.marks>=70) 
		{
			grade = "B";
			disc = "Good";
		}
		else if (this.marks<70 && this.marks>=60) 
		{
			grade = "C";
			disc = "Competent";
		}
		else if (this.marks<60 && this.marks>=50) 
		{
			grade = "D";
			disc = "Passing";
		}
		else
		{
			grade ="F";
			disc = "Failing";
		}
		this.report[0] = grade;	
		this.report[1] = disc;
		return this.report;
	}
	
	public String getInformation()
	{
		String info = "";
		if (this.prof==null)
		{
			info = this.Title+" has not yet been assigned an instructor";
		}
		else
		{
			info = this.Title+", taught by "+prof.getName()+", is completed with raw marks "+this.marks+" ("+this.report[0]+" ; "+this.report[1]+")";
		}
		return info;
	}
//	CLASS METHODS (SETTERS)
	public void setTitle(String t)
	{
		this.Title = t;
	}
	
	public void setMarks(int m)
	{
		this.marks=m;
		setGrade();
	}
	
	public void setInstructor(Instructor p)
	{
		this.prof = p;
	}
	
	public void setGrade() 
	{
		if (this.marks>=90) 
		{
			this.grade = 9;
		}
		else if (this.marks<90 && this.marks>=80) 
		{
			this.grade = 8;
		}
		else if (this.marks<80 && this.marks>=70) 
		{
			this.grade = 7;
		}
		else if (this.marks<70 && this.marks>=60) 
		{
			this.grade = 6;
		}
		else if (this.marks<60 && this.marks>=50) 
		{
			this.grade = 5;
		}
		else
		{
			this.grade = 0;
		}
	}
}
