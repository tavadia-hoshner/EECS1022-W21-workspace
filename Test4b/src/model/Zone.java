package model;

public class Zone {
	private int capacity;
	private String id;
	static int serial = 23;
	private MovieRecord[] col= {};
	private String status = "0 records and 0 DVDs: {}";
	public Zone(int c) {
		this.capacity=c;
		this.id="Zone-"+serial;
		serial = serial+11;
	}

	public String getID() {
		return this.id;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public int getNumberOfMovieRecords() {
		return col.length;
	}
	
	public int getNumberOfMovieDVDs() {
		if(col.length>0) {
		int sum = 0;
		for(int i=0;i<col.length;i++)
			sum = sum+col[i].getNumberOfDVDs();
		return sum;
		}
		return 0;
	}
	
	public void updateStatus() {
		String temp = ""+getNumberOfMovieRecords()+" records and "+getNumberOfMovieDVDs()+" DVDs: {";
		int len = col.length;
		for(int i=0;i<len;i++) {
			if(i!=0)
				temp = temp+", ";
			temp=temp+col[i].getName()+" ("+col[i].getNumberOfDVDs()+")";
		}
		temp = temp +"}";
		status = temp;
	}
	
	public boolean checkCapacity() {
		boolean a = false;
		if(getNumberOfMovieDVDs()<capacity)
			a=true;
		return a;
	}
	
	public void addMovieRecord(MovieRecord x) {
		if(checkCapacity() && checkIfExists(x)) {
			int s = x.getNumberOfDVDs();
			if(this.getNumberOfMovieDVDs()+s<=capacity) {
			int len = col.length;
			MovieRecord[] temp = new MovieRecord[len+1];
			for(int i=0;i<len;i++) {
				temp[i]=col[i];
			}
			temp[len]=x;
			col=temp;
			updateStatus();}
			else 
				status="Error: insufficient space left in the zone ("+(this.getNumberOfMovieDVDs()+s-capacity)+" DVDs short)";
		}
		else if(checkIfExists(x)==false) {
			int s = x.getNumberOfDVDs();
			if(this.getNumberOfMovieDVDs()+s<=capacity) {
				int len = col.length;
				for(int i=0;i<len;i++) {
					if(col[i].getName().equals(x.getName()))
						col[i].addStock(x.getNumberOfDVDs());
				}
				this.updateStatus();
			}
			else
				status="Error: insufficient space left in the zone ("+(this.getNumberOfMovieDVDs()+s-capacity)+" DVDs short)";
		}
		
		else
			status ="Error: maximum number of movie DVDs ("+capacity+") reached";
	}
	public boolean checkIfExists(MovieRecord x) {
		boolean a = true;

		int len = col.length;
		for(int i=0;i<len;i++) {
			if (col[i].getName().equals(x.getName())){
					a =false;
			}
		}
		return a;
	}
	
	public MovieRecord[] getRecord() {
		return this.col;
	}
	
	public int getSpaceRemaining() {
		int x = this.capacity-this.getNumberOfMovieDVDs();
		return x;
	}
	
}
