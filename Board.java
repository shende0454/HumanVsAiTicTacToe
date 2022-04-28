package henderson_s.p2;

import java.util.ArrayList;
import java.util.Collection;
public class Board {
	private static int MAX_COLUMNS = 3;
	private static int MAX_ROWS = 3;
	public String[][] board;
	static class Position
	{
		public int column;
		public int row;
		public Position(int row, int column)
		{
			this.column = column;
			this.row = row;
		}
		public Position() {
			
		}
		public Board.Position clone()
		{
			return this;
		}
		public boolean equals(Object object)
		{
			return this.equals(object);
			
		}
		public String toString()
		{
			String theRow;
			String theColumn;
			theRow = String.valueOf(row);
			theColumn = String.valueOf(column);
			
			return theRow.concat(",").concat(theColumn).toString();
		}
	}
	public Board()
	{
		board = new String[MAX_ROWS][MAX_COLUMNS];
		for(int i =0; i < MAX_ROWS; i++)
		{
			for(int j =0; j < MAX_COLUMNS; j++)
			{
				board[i][j] = " ";
			}		
		}
	}
	public static enum Piece 
	{
		NONE,O,X;		
	}
	public static enum State
	{
		DRAW,INCOMPLETE,OWINS,XWINS;
		
	}
	
	public Collection<Board.Position> emptyPositions()
	{
		ArrayList<Board.Position> emptyPositions = new ArrayList<>();
		for(int i =0;i < 3 ; i++)
		{
			for(int j = 0; j < 3;j++)
			{
				if(board[i][j] == " ")
				{
					emptyPositions.add(new Position(i,j));
				}
			}
		}
		return emptyPositions;
	}
	public void playPiece(Board.Position position, Board.Piece piece)
	{
		board[position.row][position.column] = piece.toString();
	}
	public Board.State getGameState()
	{
		
		Board.State stateBoard = null;
		if(board[0][0] == "X" && board[1][0] == "X" && board[2][0] == "X" || board[0][0] == "X" && board[0][1] == "X" && board[0][2] == "X" || board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X" || board[0][2] == "X" && board[1][1] == "X" && board[2][0] == "X" || board[0][1] == "X" && board[1][1] == "X" && board[2][1] == "X" || board[1][0] == "X" && board[1][1] == "X" && board[1][2] == "X"|| board[2][0] == "X" && board[1][1] == "X" && board[0][2] == "X")
		{
			stateBoard = Board.State.XWINS;
		}
		if(board[0][0] == "O" && board[1][0] == "O" && board[2][0] == "O" || board[0][0] == "O" && board[0][1] == "O" && board[0][2] == "O" || board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O" || board[0][2] == "O" && board[1][1] == "O" && board[2][0] == "O" || board[0][1] == "O" && board[1][1] == "O" && board[2][1] == "O" || board[1][0] == "O" && board[1][1] == "O" && board[1][2] == "O" || board[2][0] == "O" && board[1][1] == "O" && board[0][2] == "O")
		{
			stateBoard = Board.State.OWINS;
		}	
		if(stateBoard != Board.State.XWINS && stateBoard != Board.State.OWINS )
		{
			if(this.emptyPositions().size() == 0)
			{
			stateBoard = Board.State.DRAW;
			}
			else
			{
				stateBoard = Board.State.INCOMPLETE;
			}
		}
	
		return stateBoard;
	}
	public Board.Piece getPiece(Board.Position position)
	{
		Board.Piece pieceToReturn = null;
		if(board[position.row][position.column].toString().equalsIgnoreCase("x"))
		{
			pieceToReturn = Piece.X;
		}
		else if(board[position.row][position.column].toString().equalsIgnoreCase("o"))
		{
			pieceToReturn = Piece.O;
		}
		else if(board[position.row][position.column].toString().equalsIgnoreCase(" ") || board[position.row][position.column].toString().equalsIgnoreCase("none"))
		{
			pieceToReturn = Piece.NONE;
		}
		return pieceToReturn;
	}
	public String toString() // Ask for clarity
	{
		StringBuilder str = new StringBuilder();
		for(int i =0; i < MAX_ROWS; i++)
		{
			for(int j =0; j < MAX_COLUMNS; j++)
			{
				if(board[i][j] != " ")
				{
					str.append(board[i][j]);
				}
				
			}
		}
		
		return str.toString();
	
	}
	
	
}
