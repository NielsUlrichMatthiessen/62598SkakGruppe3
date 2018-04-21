package data;

import java.awt.Point;
import java.util.ArrayList;

import interfaces.IBoard;
import interfaces.IField;
import interfaces.IPiece;
import interfaces.IPiece.Color;
import interfaces.IPiece.Type;

public class Board implements IBoard {
	
	IField[][] chessBoard;
	ArrayList<IBoard> childBoards = new ArrayList<>();

	
	
	
	public Board() {
		chessBoard = new IField[8][8];
		
		
	}
	
	/**
	 * 
	 */
	@Override
	public ArrayList<IPiece> getPieces() {
		IPiece king = null;										//We need the king seperately. If king is in check check, we need to find out first.
		ArrayList<IPiece> pieces = new ArrayList<IPiece>();		//The other pieces.
		ArrayList<IPiece> finalList = new ArrayList<IPiece>();	//All the pieces, king first. 
		IPiece temp;
		for(int i = 0;i<8;i++) {
			for(int j = 0;j<8;j++) {
				temp = chessBoard[i][j].getPiece();
				if(temp.getType().equals(Type.King)) {
					king = temp;
				}
				else {
					pieces.add(temp);
				}
			}
		}
		finalList.add(king);
		finalList.addAll(pieces);
		
		return finalList;
	}

	@Override
	public boolean outOfBounds(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allyPiecePresent(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean enemyPiecePresent(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCheckmate(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IBoard generateNewBoardState(Point p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPiece getPiece(Point p) {
		return chessBoard[((int) p.getX())-1][((int)p.getY())-1].getPiece();
	}
	
	@Override
	public IField getField(Point p) {
		return chessBoard[((int) p.getX())-1][((int)p.getY())-1];
	}
	
	
	//Sets the field 
	@Override
	public void setFieldEnPassant(Point p, Color color) {
		switch(color) {
		case BLACK:
			chessBoard[((int) p.getX())][((int)p.getY())-1].setEnPassant(true);
			break;
			
		case WHITE:
			chessBoard[((int) p.getX())-2][((int)p.getY())-1].setEnPassant(true);
			break;
			
		default:
			System.out.println("SetFieldEnPassant: No Color");
			break;
		
		}
			}
	
	
		
	
	
	
	

}
