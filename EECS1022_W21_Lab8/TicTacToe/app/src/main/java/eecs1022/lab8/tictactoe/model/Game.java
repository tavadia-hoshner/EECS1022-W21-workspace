package eecs1022.lab8.tictactoe.model;

public class Game {
    private String p1;
    private String p2;
    private char cp;
    private String status;
    private char win;
    char [][] gameboard = {
            {'_', '_', '_'},
            {'_', '_', '_'},
            {'_', '_', '_'}
    };
    public Game(String p1,String p2){
        this.p1 = p1;
        this.p2 = p2;
        this.cp = 'x';
        this.win = 'n';
        this.status = this.p1+"'s turn to play...";
    }

    public String getStatus(){
        return this.status;
    }

    public char[][] getBoard() {
        return gameboard;
    }

    public String getCurrentPlayer(){
        if (cp=='x'&&win=='n')
            return this.p1;
        else if (win=='n')
            return this.p2;
        else
            return null;
    }

    public void setWhoPlaysFirst(char sp){
        if (sp=='x') {
            cp = 'x';
            this.status = this.p1 + "'s turn to play...";
        }
        else if(sp=='o') {
            cp = 'o';
            this.status = this.p2 + "'s turn to play...";
        }
    }

    public void changePlayer(char p){
        if(p=='x') {
            this.cp = 'o';
            this.status = this.p2 + "'s turn to play...";
        }
        else if(p=='o') {
            this.cp = 'x';
            this.status = this.p1 + "'s turn to play...";
        }
    }

    public void checkWinner(){
        if(gameboard[0][0]==gameboard[0][1]&&gameboard[0][1]==gameboard[0][2]&&gameboard[0][0]!='_')
            win= gameboard[0][0];
        else if(gameboard[1][0]==gameboard[1][1]&&gameboard[1][1]==gameboard[1][2]&&gameboard[1][0]!='_')
            win= gameboard[1][0];
        else if(gameboard[2][0]==gameboard[2][1]&&gameboard[2][1]==gameboard[2][2]&&gameboard[2][0]!='_')
            win= gameboard[2][0];
        else if(gameboard[0][0]==gameboard[1][0]&&gameboard[1][0]==gameboard[2][0]&&gameboard[0][0]!='_')
            win= gameboard[0][0];
        else if(gameboard[0][1]==gameboard[1][1]&&gameboard[1][1]==gameboard[2][1]&&gameboard[0][1]!='_')
            win= gameboard[0][1];
        else if(gameboard[0][2]==gameboard[1][2]&&gameboard[1][2]==gameboard[2][2]&&gameboard[0][2]!='_')
            win= gameboard[0][2];
        else if(gameboard[0][0]==gameboard[1][1]&&gameboard[1][1]==gameboard[2][2]&&gameboard[0][0]!='_')
            win= gameboard[0][0];
        else if(gameboard[0][2]==gameboard[1][1]&&gameboard[1][1]==gameboard[2][0]&&gameboard[0][2]!='_')
            win= gameboard[0][2];
        else{
            int ctr=0;
            for(int i=0;i<3;i++)
                for(int j=0;j<3;j++)
                    if(gameboard[i][j]=='_')
                        ctr++;
            if(ctr==0)
                win = 't';
        }
        if(win=='x')
            status = "Game is over with "+p1+" being the winner.";
        if(win=='o')
            status = "Game is over with "+p2+" being the winner.";
        if(win=='t')
            status = "Game is over with a tie between "+p1+" and "+p2+".";
    }


    public void move(int r,int c){
        if (win=='x'||win=='o')
            status ="Error: game is already over with a winner.";
        else if (win=='t')
            status = "Error: game is already over with a tie.";
        else if ((r<1)||(r>3))
            status = "Error: row "+r+" is invalid.";
        else if ((c<1)||(c>3))
            status = "Error: col "+c+" is invalid.";
        else if (this.gameboard[r-1][c-1]!='_')
            status = "Error: slot @ ("+r+", "+c+") is already occupied.";
        else {
            this.gameboard[r-1][c-1]=this.cp;
            changePlayer(this.cp);
            checkWinner();
        }
    }

}
