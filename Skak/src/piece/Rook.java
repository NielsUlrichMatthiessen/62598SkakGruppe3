package piece;

import java.util.ArrayList;

import data.Values;

import java.awt.Point;

public class Rook extends Piece {
	
	private static int value = Values.ROOK;
	ArrayList<Point> legalMoves;
	
	public Rook(Color color, Point coordinates) {
		
		super(Type.Rook, color, value, coordinates);
		legalMoves = new ArrayList<>();

	}
	
	@Override
	 public ArrayList<Point> getLegalMoves() {
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
