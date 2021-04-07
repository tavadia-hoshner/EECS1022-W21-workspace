package model;

public class Store {
private Zone[] list = {};
public void addZones(Zone[] d) {
	int len = list.length;
	if(len+d.length<=100) {
		Zone[] temp = new Zone[len+d.length];
		for(int i=0;i<len;i++) {
			temp[i]=list[i];
		}
		for(int i=len;i<temp.length;i++) {
			temp[i]=d[i-len];
		}
		list = temp;
	}
}
public Zone[] getZones()
{
	return this.list;
}

public int[] getStats(String x) {
	int len = list.length;
	int Rec = 0;
	int dvd = 0;
	for(int i=0;i<len;i++) {
		MovieRecord[] f = list[i].getRecord();
		for(int j = 0;j<f.length;j++) {
			MovieRecord r = f[j];
			String n = r.getName();
			if(n.equals(x)) {
				Rec++;
				dvd = dvd + r.getNumberOfDVDs();
			}
		}
	}
	int[] temp = {Rec,dvd};
	return temp;
}

public Zone[] getZones(int x)
{
	int len = list.length;
	int ctr = 0;
	int k=0;
	for(int i=0;i<len;i++) {
		if(list[i].getSpaceRemaining()<=x)
			ctr++;
	}
	Zone[] temp = new Zone[ctr];
	for(int i=0;i<len;i++) {
		if(list[i].getSpaceRemaining()<=x) {
			temp[k]=list[i];
			k++;
		}
	}
	return temp;
}
}
