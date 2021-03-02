package model;

public class Participant {
	private String Name; 
	private int regno = 0;
	private Registration[] list = {};
	
//	CONSTUCTOR
	public Participant(String n)
	{
		this.Name=n;
	}
	
//	GETTERS
	public Registration[] getRegistrations()
	{
		return this.list;
	}
	
	public String getName()
	{
		return this.Name;
	}
	public String getGPAReport()
	{
		String rep ="";
		if (this.list.length==0)
			rep = "No GPA available yet for "+this.Name;
		else
		{
			rep =this.Name+"'s GPA of {";
			int len = this.list.length;
			int sum = 0;
			for(int i=0;i<len;i++) {
				sum = sum + this.list[i].getGrade();
				rep =rep+this.list[i].getGrade()+" ("+this.list[i].getGradeReport()[0]+"), ";
			}
			rep=rep.substring(0,rep.length()-2);
			double gpa = (double)sum/len;
			rep = rep +"}: "+String.format("%.1f", gpa);
		}
		return rep;
	}
	
	public int marksOf(String n)
	{
		int m = -1;
		int len = this.list.length;
		for (int i=0;i<len;i++)
		{
			if(this.list[i].getTitle()==n)
				return this.list[i].getMarks();
		}
		return m;
	}
	
//	SETTERS
	public void addRegistration(Registration a)
	{
		int len = this.list.length;
		if(regno<5)
		{
			Registration[] lista = new Registration[len+1];
			for(int i=0;i<len;i++)
			{
				lista[i]=this.list[i];
			}
			lista[len]=a;
			this.list=lista;
			this.regno++;
		}
	}
	
	public void addRegistration(String a)
	{
		int len = this.list.length;
		if(regno<5)
		{
			Registration[] lista = new Registration[len+1];
			for(int i=0;i<len;i++)
			{
				lista[i]=this.list[i];
			}
			lista[len]= new Registration(a);
			this.list=lista;
			this.regno++;
		}
	}
	
	public void updateMarks(String a,int m)
	{
		int len = this.list.length;
		for(int i=0;i<len;i++)
		{
			if(this.list[i].getTitle()==a)
				this.list[i].setMarks(m);
		}
	}
	public void clearRegistrations()
	{
		Registration[] blank = new Registration[0];
		this.list=blank;
	}
}
