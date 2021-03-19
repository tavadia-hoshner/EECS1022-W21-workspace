package model;

public class Warehouse {
	private int capacity = 0;
	private Equipment[] equipment = {};
	public Warehouse(int n) {
		this.capacity=n;
	}
	
	public Equipment[] getEquipments() {
		return this.equipment;
	}
	
	public Equipment[] getEquipments(String[] n) {
		int ctr = 0;
		for(int i =0;i<n.length;i++) {
			String name = n[i];
			for(int j=0;j<this.equipment.length;j++) {
				if(name.equals(this.equipment[j].getName()))
					ctr++;
			}
		}
		Equipment[] temp = new Equipment[ctr];
		int k=0;
		for(int i =0;i<n.length;i++) {
			String name = n[i];
			for(int j=0;j<this.equipment.length;j++) {
				if(name.equals(this.equipment[j].getName())) {
					temp[k]=this.equipment[j]; k++;
				}
			}
		}
		return temp;
	}
	
	public Equipment getEquipment(String n) {
		String name = n;
		for(int j=0;j<this.equipment.length;j++) {
			if(name.equals(this.equipment[j].getName()))
				return this.equipment[j];
		}
		return null;
	}
	
	public Equipment[] getEquipmentsWithinRange(int a, int b) {
		int ctr = 0;
		for(int i=0;i<this.equipment.length;i++) {
			int s = this.equipment[i].getStock();
			if(a<=s && s<=b)
				ctr++;
		}
		Equipment[] temp = new Equipment[ctr];
		int k=0;
		for(int i=0;i<this.equipment.length;i++) {
			int s = this.equipment[i].getStock();
			if(a<=s && s<=b) {
				temp[k]=this.equipment[i]; k++;
			}
		}
		return temp;
	}
	
	public void addEquipment(Equipment a) {
		boolean dne = true;
		for(int j=0;j<this.equipment.length;j++) {
			if(a.getName().equals(this.equipment[j].getName())) {
				this.equipment[j].addStock(a.getStock());
				dne = false;
			}
		}
		if(capacity>0 && dne) {
			int len = equipment.length;
			Equipment[] temp = new Equipment[len+1];
			for(int i=0;i<len;i++) {
				temp[i]=equipment[i];
			}
			temp[len]=a;
			equipment = temp;
			capacity--;
		}
	}
	
	public void addStock(String n, int s) {
		for(int j=0;j<this.equipment.length;j++) {
			if(n.equals(this.equipment[j].getName())) {
				this.equipment[j].addStock(s);
			}
		}
	}
}
