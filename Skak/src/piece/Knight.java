package piece;

import java.util.ArrayList;
import java.awt.Point;

public class Knight extends Piece {
	
	private static int value = 3;
	ArrayList<Point> legalMoves;
	
	
	
	public Knight(Color color) {
		super(Type.Knight, color, value);
		legalMoves = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ArrayList<Point> getLegalMoves() {
		 
		 legalMoves.add(new Point(-2, +1));
		 legalMoves.add(new Point(-1, +2));
		 legalMoves.add(new Point(+1, +2));
		 legalMoves.add(new Point(+2, +1));
		 legalMoves.add(new Point(+2, -1));
		 legalMoves.add(new Point(+1, -2));
		 legalMoves.add(new Point(-1, -2));
		 legalMoves.add(new Point(-2, -1));
		 
		 return legalMoves;
	 }

}
