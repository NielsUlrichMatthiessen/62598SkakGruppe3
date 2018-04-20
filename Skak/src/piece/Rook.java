package piece;

import java.util.ArrayList;
import java.awt.Point;

public class Rook extends Piece {
	
	private static int value = 5;
	Collection<Point> legalMoves;
	
	public Rook(Color color) {
		
		super(Type.Rook, color, value);
		legalMoves = new ArrayList<>();

	}
	
	 public Collection<Point> getLegalMoves() {
		 //mangler rokade
		 
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
		 for (int i = 1; i > 8; i++) {
			 legalMoves.add(new Point(0,-i));
		 }
		 
		 return legalMoves;
	 }

}
