package model;

public class Equipment {
	private String name = "";
	private int stock = 0;
	private String status;
	
	public Equipment(String s) {
		this.name=s;
		this.status = "Equipment: "+this.name+" ("+this.stock+")";
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getStock() {
		return this.stock;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void updateStatus() {
		this.status = "Equipment: "+this.name+" ("+this.stock+")";
	}
	
	public void addStock(int n) {
		if(n<=0) {
			this.status = "Error: non-positive quantity "+n;
		}
		else if(n>0) {
			this.stock = this.stock+n;
			updateStatus();
		}
	}
	
	public void removeStock(int n) {
		if(n<=0) {
			this.status = "Error: non-positive quantity "+n;
		}
		else if(this.stock<n) {
			this.status = "Error: quantity is short of "+(n-this.stock);
		}
		else if(n>0 && this.stock>=n) {
			this.stock = this.stock-n;
			updateStatus();
		}
	}
}
