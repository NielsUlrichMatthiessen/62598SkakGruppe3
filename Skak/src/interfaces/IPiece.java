package interfaces;

import java.awt.Point;
import java.util.ArrayList;

import piece.Move;

public interface IPiece {
	public enum Type {Pawn, Knight, Bishop, Rook, Queen, King};
	
	
	
	Type getType();
	int getValue();
	/**
	 * Returns the legal moves of a piece
	 * @return	Arraylist of moves
	 */
	ArrayList<Point> getLegalMoves();
	
}
