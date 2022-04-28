package henderson_s.p2;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsolePlayer implements Player {

	public Scanner scan;
	public PrintStream out;
	public Board.Piece piece;
	
		public ConsolePlayer(Scanner scan, PrintStream out, Board.Piece piece) 
		{
			scan = new Scanner(System.in);
			this.scan = scan;
			this.out = out;
			this.piece = piece;
		}
		public void makeNextMove(Board board)
		{
			int row;
			int column;
			out.println("Enter row 0-2");
			row = scan.nextInt();
			if(row<0 || row >=3)
			{
				while(row<0 || row >=3)
					{
					out.println("Enter row 0-2");
					row = scan.nextInt();
					}
			}
			out.println("Enter column 0-2");
			column = scan.nextInt();
			if(column <0 || column >=3)
			{
				while(column < 0 || column >=3)
					{
					out.println("Enter row 0-2");
					column = scan.nextInt();
					}
			}
			if(board.board[row][column] != " ")
			{
				out.println("This spot is ocupied, please choose another spot");
				out.println("Enter row 0-2");
				 row = scan.nextInt();
				if(row<0 || row >=3)
				{
					while(row<0 || row >=3)
						{
						out.println("Enter row 0-2");
						row = scan.nextInt();
						}
				}
				out.println("Enter column 0-2");
				column = scan.nextInt();
				if(column <0 || column >=3)
				{
					while(column <0 || column >=3)
						{
						out.println("Enter row 0-2");
						column = scan.nextInt();
						}
				}
			}
			board.board[row][column] = piece.toString();
			// place move
			// check game statte
		}
		

}
