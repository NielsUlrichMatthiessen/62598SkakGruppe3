package data;

import java.awt.Point;
import java.util.ArrayList;

import interfaces.IBoard;
import interfaces.IPiece;
import interfaces.IPiece.Color;
import interfaces.IPiece.Type;
import piece.Move;

public class Board implements IBoard {

	private IPiece[][] chessBoard;
	private ArrayList<IBoard> childBoards = new ArrayList<>();
	private int additionalPoints = 0;
	private Point enPassant = null;

	private boolean whiteLongCastle = true;
	private boolean whiteShortCastle = true;
	private boolean blackLongCastle = true;
	private boolean blackShortCastle = true;

	private Color turn = Color.WHITE;

	public Board() {
		chessBoard = new IPiece[8][8];
	}

	public Board(Board oldBoard, Move newMove) {
		this.chessBoard = oldBoard.chessBoard;
		this.additionalPoints += newMove.getAdditionalPoints();
		switch (newMove.getMovingPiece().getType()) {
		case Bishop:
			setPieceNull(newMove.getStartCoor());
			newMove.getMovingPiece().setCoordinates(newMove.getEndCoor());
			setPiece(newMove.getEndCoor(), newMove.getMovingPiece());
			break;

		case King:
			setPieceNull(newMove.getStartCoor());
			newMove.getMovingPiece().setCoordinates(newMove.getEndCoor());
			setPiece(newMove.getEndCoor(), newMove.getMovingPiece());
			switch (newMove.getMovingPiece().getColor()) {
			case BLACK:
				blackLongCastle = false;
				blackShortCastle = false;
				break;
			case WHITE:
				whiteLongCastle = false;
				whiteShortCastle = false;
				break;
			default:
				break;

			}
			break;

		case Knight:
			setPieceNull(newMove.getStartCoor());
			newMove.getMovingPiece().setCoordinates(newMove.getEndCoor());
			setPiece(newMove.getEndCoor(), newMove.getMovingPiece());
			break;

		case Pawn:
			int distY = (int) (newMove.getEndCoor().getY() - newMove.getEndCoor().getY());

			if (distY == 2 || distY == -2) {
				Point enPassantPoint = new Point();
				switch (newMove.getMovingPiece().getColor()) {
				case BLACK:
					enPassantPoint.setLocation(newMove.getStartCoor().getX(), 6);
					this.setEnPassant(enPassantPoint);
					break;
				case WHITE:
					enPassantPoint.setLocation(newMove.getStartCoor().getX(), 3);
					this.setEnPassant(enPassantPoint);
					break;
				default:
					break;

				}

			}
			
			setPieceNull(newMove.getStartCoor());
			newMove.getMovingPiece().setCoordinates(newMove.getEndCoor());
			setPiece(newMove.getEndCoor(), newMove.getMovingPiece());
			if (newMove.isSpecial()) {

				// TODO en passant thingy
			}
			break;
		case Queen:
			break;
		case Rook:
			break;
		default:
			break;

		}

	}

	/**
	 * 
	 */
	@Override
	public ArrayList<IPiece> getPieces() {
		IPiece king = null; // We need the king seperately. If king is in check check, we need to find out
		// first.
		ArrayList<IPiece> pieces = new ArrayList<IPiece>(); // The other pieces.
		ArrayList<IPiece> finalList = new ArrayList<IPiece>(); // All the pieces, king first.
		IPiece temp;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				temp = chessBoard[i][j];
				if (temp.getType().equals(Type.King)) {
					king = temp;
				} else {
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
		return chessBoard[((int) p.getX()) - 1][((int) p.getY()) - 1];
	}

	@Override
	public void setPieceNull(Point p) {
		chessBoard[((int) p.getX()) - 1][((int) p.getY()) - 1] = null;
	}

	@Override
	public void setPiece(Point p, IPiece piece) {
		chessBoard[((int) p.getX()) - 1][((int) p.getY()) - 1] = piece;
	}

	@Override
	public Point getEnPassant() {
		return enPassant;
	}
	@Override
	public void setEnPassant(Point enPassant) {
		this.enPassant = enPassant;
	}

}
