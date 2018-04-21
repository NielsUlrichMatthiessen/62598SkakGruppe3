package moveGeneration;

import java.awt.Point;
import java.util.ArrayList;

import data.Board;
import data.Data;
import data.Values;
import interfaces.IBoard;
import interfaces.IData;
import interfaces.IPiece;
import interfaces.IPiece.Color;
import piece.King;
import piece.Move;

public class MoveGenerator {
	private ArrayList<Board> bestMoveLastRound; // The best move last round might be good again
	private ArrayList<Board> offensiveMoves; // Usually taking a piece is quite good
	private ArrayList<Board> officerMoves; // Movement of officers. (Queen, rook, bishob, knight)
	private ArrayList<Board> pawnMoves; // The pawn movements.

	// Shit to know about.
	private boolean kingIncheck;
	private IBoard boardState;
	private IBoard newBoardState;

	IData data = new Data();

	/**
	 * Takes a boardstate, so that it knows which pieces exists.
	 */
	public MoveGenerator(IBoard boardState) {
		this.boardState = boardState;
		newBoardState = new Board();
	}

	/**
	 * generates moves for the individual piece.
	 * 
	 * @param pieces
	 *            Arraylist of moves
	 */
	public void GenerateMoves() {
		ArrayList<IPiece> pieces = boardState.getPieces();
		for (IPiece piece : pieces) {
			if (piece.getType().equals(IPiece.Type.King)) {
				this.kingIncheck = ((King) piece).isCheck();
			}

			// If the king isn't checked.
			if (!this.kingIncheck) {
				Point direction = null; // Direction piece is moving in.
				Point newDirection; // The new direction the piece is moving in. Might be the same as the old one.
				boolean sameDirectionPossible = true; // True if it's possible for the piece to go further in that
														// direction.
				ArrayList<Point> pieceMoves = piece.getLegalMoves();
				Point newCoords; // The coordinates after the move.
				for (Point p : pieceMoves) {
					newDirection = getDirection(p);
					if (direction == null) {
						direction = newDirection;
					}
					// If the piece is moving in the same direction as before.
					if (direction.equals(newDirection)) {
						// If it isn't possible to go in the same direction:
						if (!sameDirectionPossible) {
							continue;
						}
					} else {
						// If the directions aren't the same, that means that it's possible to go in
						// that direction.
						sameDirectionPossible = true;
						direction = newDirection; // Change the direction
					}

					// Find the new coordinates.
					newCoords = getNewPosition(p, piece.getCoordinates());

					// If the move is valid.
					if (!boardState.outOfBounds(newCoords)) {
						if (!(boardState.allyPiecePresent(newCoords))) {

							Move newMove = new Move();
							newMove.setStartCoor(p);
							newMove.setEndCoor(newCoords);
							newMove.setOffensive(boardState.enemyPiecePresent(newCoords));

							// Pawn moves:
							switch (piece.getType()) {
							case Bishop:
								break;
							case King:
								break;
							case Knight:
								break;
							case Pawn: {
								generatePawnMove(p, piece, newCoords, newMove);
								break;
							}
							case Queen:
								break;
							case Rook:
								break;
							default:
								break;
							}

						} else {
							// Ally present in direction. Can't move in that direction anymore.
							sameDirectionPossible = false;
						}

					}

					else {
						// Direction is now out of bounds.
						sameDirectionPossible = false;
					}

				}

			}
		}

	}

	private Point getNewPosition(Point point1, Point point2) {
		Point returnPoint = new Point();
		double x = point1.getX() + point2.getX();
		double y = point1.getY() + point2.getY();
		returnPoint.setLocation(x, y);
		return returnPoint;
	}

	private void generatePawnMove(Point diff, IPiece piece, Point newCoords, Move newMove) {
		// Can the pawn move forward?
		if (diff.getX() == 0) {
			// If the pawn isn't moving in the x direction.
			if (newMove.isOffensive()) {
				// If there is an enemy piece there, the move is not valid.
				return;
			}
			
			//If the pawn is moving 2 fields forward, en passant is possible.
			if (diff.getY() == 2 || diff.getY() == -2) {
				boardState.setFieldEnPassant(newCoords, piece.getColor());
			}
			
			// Add extra points if it is or is becoming a center pawn.
			if (2 < newCoords.getY() && newCoords.getY() < 7) {
				newMove.addAdditionalPoints(Values.CENTERPAWN);
			}
			
			//TODO pawn evolution
			
			pawnMoves.add(newMove);

			// No need to execute more code, since the move already has been added to the
			// moves list.
			return;

		} else {
			// The pawn is moving to the side. Check if offensive. Means, is there an enemy
			// piece.
			if (newMove.isOffensive()) {
				// Add extra points if a low value piece takes a higher value piece.
				if (boardState.getPiece(newCoords).getValue() > piece.getValue()) {
					newMove.addAdditionalPoints(Values.SMALLTAKEBIG);
				}
				offensiveMoves.add(newMove);

			} else {

				// If it isn't offensive (no enemy piece there) check for en passant.

				// If the piece is white
				if (piece.getColor().equals(Color.WHITE)) {
					// If it's in the correct row.
					if (piece.getCoordinates().getX() == 5) {
						// Has a pawn recently moved over this field?
						if (boardState.getField(newCoords).isEnPassant()) {
							newMove.setSpecial(true);
							pawnMoves.add(newMove);
						}
					}
				}
				// Piece is black.
				else {
					// If it's in the correct row.
					if (piece.getCoordinates().getX() == 4) {
						// Has a pawn recently moved over this field?
						if (boardState.getField(newCoords).isEnPassant()) {
							newMove.setSpecial(true);
							pawnMoves.add(newMove);
						}
					}
				}

				return;

			}
		}
	}

	private Point getDirection(Point p) {
		Point returnPoint = new Point();
		int x = 0, y = 0;
		double pointX = p.getX();
		double pointY = p.getY();
		if (pointX > 0) {
			x = 1;
		} else if (pointX < 0) {
			x = -1;
		}
		if (pointY > 0) {
			y = 1;
		} else if (pointY < 0) {
			y = -1;
		}
		returnPoint.setLocation(x, y);
		return returnPoint;
	}

}
