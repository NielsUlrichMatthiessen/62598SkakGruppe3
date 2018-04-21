package data;

import interfaces.IField;
import interfaces.IPiece;

public class Field implements IField {
	
	
	
	
	private IPiece piece;
	private boolean enPassant = false;
	
	
	
	
	
	
	
	public Field(IPiece piece) {
		this.piece = piece;
	}
	
	
	@Override
	public IPiece getPiece() {
		return piece;
	}
	@Override
	public void setPiece(IPiece piece) {
		this.piece = piece;
	}
	@Override
	public boolean isEnPassant() {
		return enPassant;
	}
	@Override
	public void setEnPassant(boolean enPassant) {
		this.enPassant = enPassant;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
