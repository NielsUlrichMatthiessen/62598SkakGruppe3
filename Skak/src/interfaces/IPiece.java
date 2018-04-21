package interfaces;

import java.awt.Point;
import java.util.ArrayList;

public interface IPiece {
	public enum Type {Pawn, Knight, Bishop, Rook, Queen, King};
	public enum Color {WHITE, BLACK}
	
	
	Type getType();
	int getValue();
	Point getCoordinates();
	void setCoordinates(Point coordinates);
	/**
	 * Returns the legal moves of a piece
	 * @return	Arraylist of moves
	 */
	ArrayList<Point> getLegalMoves();
	Color getColor();
	
}
