package eecs1022.lab7.bank.model;

public class Bank {
    private String status;
    private Client[] accounts = {};
    public Bank(){
        this.status="Accounts: {}";
    }
    public String getStatus(){
        return this.status;
    }

    public String[] getStatement(String name){
        String[] stat = {};
        int acexists = accountExists(name);
        if(acexists>=0) {
            Client a = accounts[acexists];
            stat =  a.getStatement();
            normalStatus();
        }
        else if (acexists==-5){
            status="Error: From-Account "+name+" does not exist";
            return null;
        }
        return stat;
    }

    public void deposit(String name, double amt){
        int acexists = accountExists(name);
        if(amt<=0)
        {
            this.status="Error: Non-Positive Amount";
        }
        if(acexists>=0 && amt>0) {
            Client a = accounts[acexists];
            a.deposit(amt);
            normalStatus();
        }
        if(acexists==-5)
            status="Error: To-Account "+name+" does not exist";
    }

    public void withdraw(String name, double amt){
        int acexists = accountExists(name);
        if(acexists>=0 && amt>0){
            Client a = accounts[acexists];
            if(amt<=a.getBalance()){
                a.withdraw(amt);
                normalStatus();
            }
            else
                this.status="Error: Amount too large to withdraw";
        }
        if(amt<=0)
        {
            this.status="Error: Non-Positive Amount";
        }
        if (acexists==-5)
        {
            this.status="Error: From-Account "+name+" does not exist";
        }
    }

    public void transfer(String from,String to, double amt){
        int acexists1 = accountExists(from);
        int acexists2 = accountExists(to);
        if(acexists1>=0){
            Client f = accounts[acexists1];
            if(f.getBalance()<amt)
                status= "Error: Amount too large to transfer";
        }
        if(amt<=0)
        {
            this.status="Error: Non-Positive Amount";
        }
        if (acexists2==-5)
        {
            this.status="Error: To-Account "+to+" does not exist";
        }
        if (acexists1==-5)
        {
            this.status="Error: From-Account "+from+" does not exist";
        }
        if(acexists1>=0 && acexists2>=0 && accounts[acexists1].getBalance()>=amt && amt>0){
            Client f = accounts[acexists1];
            Client t = accounts[acexists2];
            f.withdraw(amt);
            t.deposit(amt);
            normalStatus();
        }
    }

    public void addClient(String name,double balance)
    {
        int acexists = accountExists(name);
        if(balance<=0)
        {
            this.status="Error: Non-Positive Initial Balance";
        }

        if (acexists!=-5)
        {
            this.status="Error: Client "+name+" already exists";
        }
        if(accounts.length==6)
            this.status = "Error: Maximum Number of Accounts Reached";

        if (acexists==-5 && balance>0 && accounts.length<6) {
            Client x = new Client(name, balance);
            int len = accounts.length;
            Client[] temp = new Client[len + 1];
            for (int i = 0; i < accounts.length; i++) {
                temp[i] = accounts[i];
            }
            temp[len] = x;
            this.accounts = temp;
            normalStatus();
        }

    }

    public int accountExists(String n){
        for (int i = 0; i < accounts.length; i++)
        {
            Client a = accounts[i];
            if(n.equals(a.getName()))
                return i;
        }
        return -5;
    }

    public void normalStatus(){
        int len = accounts.length;
        String tempStat = "Accounts: {";
        for (int i=0;i<len;i++){
//            System.out.println(i);
            Client a = accounts[i];
            tempStat=tempStat + a.getName()+": $";
            tempStat=tempStat + String.format("%.2f",a.getBalance())+", ";
        }
        tempStat=tempStat.substring(0,tempStat.length()-2);
        tempStat=tempStat+"}";
        status=tempStat;
    }
}
