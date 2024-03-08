import board.Board;
import player.Player;
import game.Game;

public class App {
    public static void main(String[] args) throws Exception{
        Board br = new Board(3,'_');
        br.getBoardConfiguration();
        Player p1 =new Player();
        p1.setDetails("siddiq", 22, "madhurawada", 895196445, "sar@gmail.com",'X' );
        System.out.println(p1.getPlayer());
        Player p2 = new Player();
        p2.setDetails("siraj",14,"hyderabad", 755062983, "siraj@gmail.com",'0' );
        System.out.println(p2.getPlayer());
       
        Player[] players = {p1, p2};
        Game g = new Game(players, br);
        g.play();
    }
}
