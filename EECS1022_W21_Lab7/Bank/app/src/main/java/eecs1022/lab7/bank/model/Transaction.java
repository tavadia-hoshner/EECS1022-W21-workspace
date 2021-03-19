package eecs1022.lab7.bank.model;

public class Transaction {
    private String status;
    public Transaction(String type, double amt){
        this.status="Transaction "+type+": $"+String.format("%.2f",amt);
    }
    public String getStatus(){
        return this.status;
    }
}
