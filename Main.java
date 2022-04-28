package henderson_s.p2;
import static java.lang.System.out;
import java.util.Scanner;

public class Main {
		 static Player player1;
		 static Player player2;
		 static int p1 = 1;
		 static int p2 = 2;
     	 static Board board = new Board();
    	 static Board.Piece x = Board.Piece.X;
    	 static Board.Piece o = Board.Piece.O;	 
    	 static int turn = 1;
	public static void main(String[] args)
  	{ 
		 Scanner scan = new Scanner(System.in);
    	 ConsoleInterface theInterface = new ConsoleInterface(scan,out); 
    	 if(theInterface.askIfPlayerShouldBeAComputer(p1) == true)
    	 {
    		 player1 = new ComputerPlayer(x);
    	 }
    	 else
    	 {
    		 player1 = new ConsolePlayer(scan, out, x);
    	 }
    	 if(theInterface.askIfPlayerShouldBeAComputer(p2) == true)
    	 {
    		 player2 = new ComputerPlayer(o);
    	 }
    	 else
    	 {
    		 player2 = new ConsolePlayer(scan, out, o);
    	 }
    	 while(board.getGameState() != Board.State.XWINS || board.getGameState() != Board.State.OWINS)
    	 {
    	 player1.makeNextMove(board);
    	 turn = 2;
    	 theInterface.printBoard(board);
    	 out.println(board.getGameState());
    	 player2.makeNextMove(board);
    	 turn = 1;
    	 theInterface.printBoard(board);
    	 out.println(board.getGameState());
    	 }
  	}


}
