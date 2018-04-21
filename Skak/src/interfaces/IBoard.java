package interfaces;

import java.awt.Point;
import java.util.ArrayList;

import interfaces.IPiece.Color;


public interface IBoard {

	
	
	ArrayList<IPiece> getPieces();
	boolean outOfBounds(Point p);
	boolean allyPiecePresent(Point p);
	boolean enemyPiecePresent(Point p);
	boolean isCheckmate(Point p);
	IBoard generateNewBoardState(Point p);
	
	
	IPiece getPiece(Point p);
	IField getField(Point p);
	void setFieldEnPassant(Point p, Color color);
	
	
	
}
