package piece;

import java.awt.Point;

public class Move {
	
	
	private Piece movingPiece;				//The actual moving piece.
	private Point startCoor;				//Where it comes from
	private Point endCoor;					//Where it will go
	private boolean offensive;				//Taking a piece
	private int additionalPoints = 0;		//Add extra points to the move. Ie. Move to a spot that another piece covers
	private boolean special = false;		//For en passant and pawn evolution.
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Piece getMovingPiece() {
		return movingPiece;
	}
	public void addMovingPiece(Piece movingPiece) {
		this.movingPiece = movingPiece;
	}
	public Point getStartCoor() {
		return startCoor;
	}
	public void setStartCoor(Point startCoor) {
		this.startCoor = startCoor;
	}
	public Point getEndCoor() {
		return endCoor;
	}
	public void setEndCoor(Point endCoor) {
		this.endCoor = endCoor;
	}
	public boolean isOffensive() {
		return offensive;
	}
	public void setOffensive(boolean offensive) {
		this.offensive = offensive;
	}
	public int getAdditionalPoints() {
		return additionalPoints;
	}
	public void addAdditionalPoints(int additionalPoints) {
		this.additionalPoints += additionalPoints;
	}
	public boolean isSpecial() {
		return special;
	}
	public void setSpecial(boolean special) {
		this.special = special;
	}
	
	
	
	
	
	
	
	
	

}
