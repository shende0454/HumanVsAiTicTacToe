package henderson_s.p2;

import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleInterface {
private Scanner scanner;
private PrintStream printer;
	public ConsoleInterface(Scanner scanner, PrintStream printer)
	{
		this.scanner = scanner;
		this.printer = printer; 
	}
	public boolean askIfPlayerShouldBeAComputer(int playerNr)
	{
		String answer;
		boolean shouldBeAComputer = false;
		printer.print("Should player " + playerNr + " be a computer player (Yes/No?) ");
		answer = scanner.next();
		if(answer.equalsIgnoreCase("yes"))
		{
			shouldBeAComputer = true;
		}
		else if(answer.equalsIgnoreCase("no"))
		{
			shouldBeAComputer = false;
		}
		return shouldBeAComputer;
		
	}
	public void printBoard(Board board)
	{
		printer.println();
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board.board[i][j] == " ")
                {
                    printer.print("_");
                } 
                else 
                {
                    printer.print(board.board[i][j]);
                }
                if(j < 2) 
                {
                    printer.print(":");
                } 
                else 
                {
                    printer.println("");
                } 
             }
         }
         printer.println();
	}

}
