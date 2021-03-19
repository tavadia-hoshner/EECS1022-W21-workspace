package eecs1022.lab7.bank.model;

public class Client {
    private String name;
    private double balance;
    private String status;
    private String[] statement = {""};
    public Client(String Name, double Balance){
        this.name=Name;
        this.balance=Balance;
        this.statement[0]=getStatus();
    }

    public String getName(){
        return name;
    }

    public double getBalance(){
        return balance;
    }

    public String getStatus(){
        this.status = this.name+": $"+String.format("%.2f",this.balance);
        return status;
    }

    public String[] getStatement(){
        this.statement[0] = getStatus();
        return statement;
    }

    public void deposit(double amt){
        Transaction x = new Transaction("DEPOSIT", amt);
        this.balance=this.balance+amt;
        appendStatemant(x.getStatus());
    }

    public void withdraw(double amt){
        Transaction y = new Transaction("WITHDRAW", amt);
        this.balance=this.balance-amt;
        appendStatemant(y.getStatus());
    }

    public void appendStatemant(String s){
        if(statement.length<11) {
            int len = statement.length;
            String[] temp = new String[len + 1];
            for (int i = 1; i < statement.length; i++)
            {
                temp[i] = statement[i];
            }
            temp[len] = s;
            temp[0] = getStatus();
            this.statement = temp;
        }
    }


}
