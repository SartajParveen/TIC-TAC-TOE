package game;
import player.Player;
import board.Board;
import java.util.*;
public class Game {
    Player[] players;
    Board board;
    int turn;
    int noOfMoves;
    boolean gameOver;
    String cross;
    String zero;
    public Game(Player[] p,Board b){
        this.players=p;
        this.board=b;
        this.turn=0;
        this.noOfMoves=0;
        this.gameOver=false;
        StringBuilder z = new StringBuilder();
        StringBuilder c = new StringBuilder();
        for(int i=0;i<board.size;i++){
            z.append(p[0].getSymbol());
            c.append(p[1].getSymbol());
        }
        this.cross=c.toString();
        this.zero=z.toString();
    }
    public void play(){
        printBoardConfig();
        int sz = board.size;
        while(!gameOver){
            noOfMoves++;
            int idx=getIndex();
            int row =idx/sz;
            int col =idx%sz;
            board.mat[row][col]=players[turn].getSymbol();
            if(noOfMoves>=sz*sz){
                System.out.println("Game Draw");
                return ;
            }
            if(noOfMoves>=2*sz-1 && checkCombinations()){
                gameOver=true;
                printBoardConfig();
                System.out.println("winner : "+players[turn].getPlayer());
                return; 
            }
            turn=(turn+1)%2;
            printBoardConfig();
        }
    }
    public void printBoardConfig(){
        int sz=this.board.size;
        for(int i=0;i<sz;i++){
            for(int j=0;j<sz;j++){
                System.out.print(board.mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int getIndex(){
        while(true){
            System.out.println("Player: "+players[turn].getPlayer() +"  give one position ");
            Scanner scn = new Scanner(System.in);
            int pos=scn.nextInt()-1;
            int sz=board.size;
            int row=pos/sz;
            int col=pos%sz;
            if(row<0 ||row>=sz || col<0 || col>=sz){
                System.out.println("Invalid Position");
                continue;
            }
            if(board.mat[row][col]!='_'){
                System.out.println("Position already occupied");
                continue;
            }
            return pos;
        }
    }
    public boolean checkCombinations(){
        int sz= board.size;
        for(int i=0;i<sz;i++){
            StringBuilder sb = new StringBuilder();
         for(int j=0;j<sz;j++){
            sb.append(board.mat[i][j]);
         }
         String pattern1 =sb.toString();
         if(pattern1.equals(zero) || pattern1.equals(cross)){
            return true;
         }
        }
        for(int i=0;i<sz;i++){
            StringBuilder sb = new StringBuilder();
         for(int j=0;j<sz;j++){
            sb.append(board.mat[j][i]);
         }
         String pattern2 =sb.toString();
         if(pattern2.equals(zero) || pattern2.equals(cross)){
            return true;
         }
        }
        int i=0,j=0;
        StringBuilder sd= new StringBuilder();
        while(i<sz){
            sd.append(board.mat[i][j]);
            i++;
            j++;
        }
        String pattern3 = sd.toString();
        if(pattern3.equals(zero) || pattern3.equals(cross)){
            return true;
        }
        i=0;j=sz-1;
        StringBuilder sd1 = new StringBuilder();
        while(i<sz){
            sd1.append(board.mat[i][j]);
            i++;
            j--;
        }
        String pattern4 = sd1.toString();
        if(pattern4.equals(zero) || pattern4.equals(cross)){
            return true;
        }
        return false;      
    }
}

