package piece;

import java.util.*;
import java.awt.Point;

public class Pawn extends Piece{
	
	private static int value = 1;
	ArrayList<Point> legalMoves;

	public Pawn(Color color) {
		super(Type.Pawn, color, value);
		legalMoves = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ArrayList<Point> getLegalMoves() {
		legalMoves.add(new Point(0, +1));
		legalMoves.add(new Point(0, +2));
		legalMoves.add(new Point(+1,+1));
		legalMoves.add(new Point(-1 , +1));
		
		return legalMoves;
    }

}