package piece;

import java.util.ArrayList;

import data.Values;

import java.awt.Point;

public class King extends Piece {
	
	private boolean check;		//King checked (I skak)
	private static int value = Values.KING;
	private boolean kingMoved = false;
	
	
	ArrayList<Point> legalMoves;
	
	
	public King(Color color, Point coordinates) {
		super(Type.King, color, value, coordinates);
		legalMoves = new ArrayList<>();	
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}
	
	@Override
	 public ArrayList<Point> getLegalMoves() {
		 //mangler rokade
		 
		 legalMoves.add(new Point(+1, 0));
		 legalMoves.add(new Point(0, +1));
		 legalMoves.add(new Point(-1, 0));
		 legalMoves.add(new Point(0, -1));
		 legalMoves.add(new Point(+1, +1));
		 legalMoves.add(new Point(+1, +1));
		 legalMoves.add(new Point(-1, -1));
		 legalMoves.add(new Point(+1, -1));
		 
		 return legalMoves;
        }



	
	

}
