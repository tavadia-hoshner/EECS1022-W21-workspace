package model;

public class VendingMachine {
	private String vmstatus;
	private int[] stock = {0,0,0,0};
	public VendingMachine() 
	{
		this.vmstatus = "Empty VM Started";
	}
	
	public String checkStatus()
	{
		return this.vmstatus;
	}
	
	public String checkStock()
	{
		String stock = "Stock: Coke ("+this.stock[0]+"), Orange Juice ("+this.stock[1]+"), Kitkat Chunky Bar ("+this.stock[2]+"), Lay's Classic Chips ("+this.stock[3]+")";
		return stock;
	}
	
	public void add(String item,int amt) {
		if(item=="Coke") {
			this.stock[0]=this.stock[0]+amt;
			this.vmstatus = "Product added: Coke ("+amt+")";
		}
		else if (item=="Orange Juice") {
			this.stock[1]=this.stock[1]+amt;
			this.vmstatus = "Product added: Orange Juice ("+amt+")";
		}
		else if (item=="Kitkat Chunky Bar") {
			this.stock[2]=this.stock[2]+amt;
			this.vmstatus = "Product added: Kitkat Chunky Bar ("+amt+")";
		}
		else if (item=="Lay's Classic Chips") {
			this.stock[3]=this.stock[3]+amt;
			this.vmstatus = "Product added: Lay's Classic Chips ("+amt+")";
		}
		else
			this.vmstatus="Invalid product: "+item;
	}
	
	public void dispense(String item,int amt) {
		if(item=="Coke") {
			this.stock[0]=this.stock[0]-amt;
			this.vmstatus = "Product removed: Coke ("+amt+")";
		}
		else if (item=="Orange Juice") {
			this.stock[1]=this.stock[1]-amt;
			this.vmstatus = "Product removed: Orange Juice ("+amt+")";
		}
		else if (item=="Kitkat Chunky Bar") {
			this.stock[2]=this.stock[2]-amt;
			this.vmstatus = "Product removed: Kitkat Chunky Bar ("+amt+")";
		}
		else if (item=="Lay's Classic Chips") {
			this.stock[3]=this.stock[3]-amt;
			this.vmstatus = "Product removed: Lay's Classic Chips ("+amt+")";
		}
		else
			this.vmstatus="Invalid product: "+item;
	}
	
	public String checkStock(String item) {
		String res ="";
		if(item=="Coke") {
			res ="Coke ("+this.stock[0]+")";
		}
		else if (item=="Orange Juice") {
			res ="Orange Juice ("+this.stock[1]+")";
		}
		else if (item=="Kitkat Chunky Bar") {
			res ="Kitkat Chunky Bar ("+this.stock[2]+")";
		}
		else if (item=="Lay's Classic Chips") {
			res ="Lay's Classic Chips ("+this.stock[2]+")";
		}
		else
			res = "Invalid product: "+item;
		return res;
	}
	
}
