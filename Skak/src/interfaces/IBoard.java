package interfaces;

import java.awt.Point;
import java.util.ArrayList;


public interface IBoard {

	
	
	ArrayList<IPiece> getPieces();
	boolean outOfBounds(Point p);
	boolean allyPiecePresent(Point p);
	boolean enemyPiecePresent(Point p);
	boolean isCheckmate(Point p);
	IBoard generateNewBoardState(Point p);
	
	
	IPiece getPiece(Point p);
	void setPieceNull(Point p);
	void setPiece(Point p, IPiece piece);
	Point getEnPassant();
	void setEnPassant(Point enPassant);
	
	
	
}
