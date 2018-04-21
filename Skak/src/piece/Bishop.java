package piece;

import java.util.ArrayList;
import java.awt.Point;

public class Bishop extends Piece {
	
	private static int value = 3;
	ArrayList<Point> legalMoves;
	
	public Bishop(Color color) {
		
		super(Type.Bishop,color, value);
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
