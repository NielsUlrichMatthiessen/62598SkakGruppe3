package interfaces;

import java.awt.Point;
import java.util.ArrayList;

import interfaces.IPiece.Color;


public interface IBoard {

	
	
	ArrayList<IPiece> getPieces();
	boolean outOfBounds(Point p);
	boolean allyPiecePresent(Point p, Color color);
	boolean enemyPiecePresent(Point p, Color color);
	boolean isCheckmate(Point p);
	IBoard generateNewBoardState(Point p);
	
	
	IPiece getPiece(Point p);
	void setPieceNull(Point p);
	void setPiece(Point p, IPiece piece);
	Point getEnPassant();
	void setEnPassant(Point enPassant);
	void setTurn(Color turn);
	Color getTurn();
	void setBlackShortCastle(boolean blackShortCastle);
	boolean isBlackShortCastle();
	void setBlackLongCastle(boolean blackLongCastle);
	boolean isBlackLongCastle();
	void setWhiteShortCastle(boolean whiteShortCastle);
	boolean isWhiteShortCastle();
	void setWhiteLongCastle(boolean whiteLongCastle);
	boolean isWhiteLongCastle();
	void setAdditionalPoints(int additionalPoints);
	int getAdditionalPoints();
	void addChildBoard(IBoard newBoard);
	boolean isFieldthreatened(Point field);
	
	
	
}
