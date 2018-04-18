package interfaces;

import java.util.ArrayList;

import piece.Piece;

public interface IData {
	
	
	ArrayList<Piece> getWhitePieces();
	void setWhitePieces(ArrayList<Piece> whitePieces);
	ArrayList<Piece> getBlackPieces();
	void setBlackPieces(ArrayList<Piece> blackPieces);

}
