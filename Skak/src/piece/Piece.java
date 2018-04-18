package piece;

import java.util.ArrayList;

import interfaces.IPiece;

public abstract class Piece implements IPiece {
	
	
	
	
	private Type type;
		
	private int value;
	
	private ArrayList<Move> moves;
	
	
	
	
	
	
	public Piece(Type type, int value) {
		super();
		this.type = type;
		this.value = value;
	}






	public Type getType() {
		return type;
	}
	public int getValue() {
		return value;
	}






	public ArrayList<Move> getMoves() {
		return moves;
	}






	


	
	
	
	
	
	
}
