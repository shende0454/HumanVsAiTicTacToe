package henderson_s.p2;
import java.util.ArrayList;


import henderson_s.p2.Board.Position;

public class ComputerPlayer implements Player 
{
	private Board.Piece piece;
	private boolean isCachingEnabled;	
	private ULHashMap<Board,Integer>hashMap= new ULHashMap<>();
 public ComputerPlayer(Board.Piece piece)
 {
	 this.piece = piece;
 }
 public ComputerPlayer(Board.Piece piece, boolean cachingEnabled)
 {
	 this.piece = piece;
	 isCachingEnabled = cachingEnabled;
 }

public void makeNextMove(Board board)
{
	Position cpuMove = null;
	int scoreM = Integer.MIN_VALUE;
	ArrayList<Position> unusedPositions = (ArrayList<Position>) board.emptyPositions();
	if(unusedPositions.size() == 0)
	{
		return;
	}
	for(int i =0; i < unusedPositions.size(); i++)
	{
		Board.Position pos = unusedPositions.get(i);
		board.playPiece(pos, this.piece);
		int score = minimax(board, pos, true, 0);
		board.board[pos.row][pos.column] = " ";
		if(score > scoreM)
		{
			scoreM = score;
			cpuMove = new Position(pos.row, pos.column);	
		}
	}
	board.board[cpuMove.row][cpuMove.column] = this.piece.toString();

}
private int minimax(Board board, Position position, boolean maxP, int depth)
{
	if(board.getGameState() == Board.State.XWINS)
	{
		return 1;
	}
	if(board.getGameState() == Board.State.OWINS)
	{
		return -1;
	}
	if(board.getGameState() == Board.State.DRAW)
	{
		return 0;
	}
	ArrayList<Position> unusedPositions = (ArrayList<Position>) board.emptyPositions();
	int maximum = Integer.MIN_VALUE;
		if(maxP == true)
		{
			for(int i =0 ; i< unusedPositions.size(); i++)
			{
		    Board.Position pos = new Position(unusedPositions.get(i).row,unusedPositions.get(i).column);
			board.playPiece(pos, this.piece);
			int score = minimax(board, pos, false, depth - 1);
			maximum = Math.max(score,maximum);
			board.board[pos.row][pos.column] = " ";
			hashMap.insert(board, score);
			if(score > maximum)
			{
				maximum = score;
			}
			}
			return maximum;
		}
		else 
		{
			int minimum = Integer.MAX_VALUE;
			Board.Piece otherPiece;
		  
			if(this.piece == Board.Piece.X)
			{
				otherPiece = Board.Piece.O;
			}
			else
			{
				otherPiece = Board.Piece.X;
			}
			for(int i =0 ; i< unusedPositions.size(); i++)
			{
		    Board.Position pos = new Position(unusedPositions.get(i).row,unusedPositions.get(i).column);
			board.playPiece(pos, otherPiece);
			int score = minimax(board, pos, true, depth - 1);
			minimum = Math.min(score, minimum);
			board.board[pos.row][pos.column] = " ";
			hashMap.insert(board, score);
			if(score > minimum)
			{
			 minimum = score;
			}
			}return minimum;
		}
		
	}
}



