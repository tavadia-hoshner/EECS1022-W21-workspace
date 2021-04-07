package model;

public class MovieRecord {
	private String name;
	private int stock;
	private Zone zone;
	private String id;
	static int order=1;
	
	public MovieRecord(String n,int s,Zone z) {
		this.name=n;
		this.stock=s;
		this.zone=z;
		this.id=z.getID()+"-"+n+"-"+order;
		order++;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNumberOfDVDs() {
		return this.stock;
	}
	
	public Zone getZone() {
		return this.zone;
	}
	
	public String getID() {
		return this.id;
	}

	public void addStock(int x) {
		this.stock=stock+x;
	}
	}
