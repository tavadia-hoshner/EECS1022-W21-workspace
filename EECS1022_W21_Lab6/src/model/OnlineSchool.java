package model;

public class OnlineSchool {
	public Participant[] list = new Participant[0];
	int participantlen = 0;
	
	public void addParticipant(Participant a)
	{
		if(participantlen<100)
		{
			int len = this.list.length;
			Participant[] lista = new Participant[len+1];
			for(int i=0;i<len;i++)
			{
				lista[i]=this.list[i];
			}
			lista[len]=a;
			this.list=lista;
			participantlen++;
		}
	}
	
	public Participant[] getParticipants(String s)
	{
		int len = this.list.length;
		int ctr = 0;
		for(int i=0;i<len;i++)
		{
			int len2 = (this.list[i].getRegistrations()).length;
			for(int j =0;j<len2;j++)
			{
				if (this.list[i].getRegistrations()[j].getTitle()==s)
					ctr++;
			}			
		}
		Participant[] templist = new Participant[ctr];
		int k=0;
		for(int i =0;i<this.list.length;i++)
		{
			Participant a = this.list[i];
			Registration[] listr = a.getRegistrations();
			int len2 = listr.length;
			for(int j =0;j<len2;j++)
			{
				if (listr[j].getTitle().equals(s)) {
					templist[k]=a;
					k++;
				}
			}
		}
		return templist;
	}
}
