package piece;

import java.awt.Point;
import java.util.ArrayList;

import data.Values;

public class Bishop extends Piece {
	
	private static int value = Values.BISHOP;
	ArrayList<Point> legalMoves;
	
	public Bishop(Color color, Point coordinates) {
		
		super(Type.Bishop,color, value, coordinates);
		legalMoves = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ArrayList<Point> getLegalMoves() {
		
		//diagonalt op positiv retning
		for (int i = 1; i < 8; i++) {
			legalMoves.add(new Point(+i,+i));
		}
		
		//diagonalt ned positiv retning
		for (int i = 1; i < 8; i++) {
			legalMoves.add(new Point(+i,-i));
		}
		
		//diagonalt ned negative retning
		for (int i = 1; i > 8; i++) {
			legalMoves.add(new Point(-i,-i));
		}
		
		//diagonalt op negative retning
		for (int i = 1; i > 8; i++) {
			legalMoves.add(new Point(-i,+i));
		}
		
		return legalMoves;
	}

	

}
