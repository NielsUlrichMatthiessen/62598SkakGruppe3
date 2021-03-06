package piece;

import java.util.*;

import data.Values;

import java.awt.Point;

public class Queen extends Piece {
	
	private static int value = Values.QUEEN;
	ArrayList<Point> legalMoves;
	
	
	public Queen(Color color, Point coordinates) {
		super(Type.Queen, color, value, coordinates);
		legalMoves = new ArrayList<>();

	}
	
	@Override
	public ArrayList<Point> getLegalMoves() {
		
		//Taarn bevægelser
		//op
		for (int i = 1; i < 8; i++) {
			legalMoves.add(new Point (+i, 0));
		}
		
		//ned
		for (int i = 1; i > 8; i++) {
			legalMoves.add(new Point(-i, 0));
		}
		
		//højre
		for (int i = 1; i < 8; i++) {
			legalMoves.add(new Point(0,+i));
		}
		
		//venstre
		for (int i = -1; i > -8; i--) {
			legalMoves.add(new Point(0,-i));
		}
		
		// Loeber bevægelser
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
