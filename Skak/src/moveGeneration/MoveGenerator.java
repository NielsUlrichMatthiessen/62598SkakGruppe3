package moveGeneration;

import java.util.ArrayList;

import data.Data;
import interfaces.IData;
import interfaces.IPiece;
import piece.King;
import piece.Move;

public class MoveGenerator {
	private ArrayList<Move> bestMoveLastRound;		//The best move last round might be good again
	private ArrayList<Move> offensiveMoves;			//Usually taking a piece is quite good
	private ArrayList<Move> officerMoves;			//Movement of officers. (Queen, rook, bishob, knight)
	private ArrayList<Move> pawnMoves;				//The pawn movements. 
	
	
	//Shit to know about.
	private boolean kingIncheck;
	
	
	
	IData data = new Data();
	
	
	
	/**
	 * generates moves for the individual piece. 
	 * @param pieces Arraylist of moves
	 */
	public void GenerateMoves(IPiece piece) {
		if(piece.getType().equals(IPiece.Type.King)) {
			this.kingIncheck = ((King) piece).isCheck();
		}
		
		//If the king isn't checked. 
		if(!this.kingIncheck) {
			for(Move m: piece.getMoves()) {
				if(m.isOffensive()) {
					this.offensiveMoves.add(m);
				}
				else if(!(m.getMovingPiece().getType().equals(IPiece.Type.Pawn))) {
					this.officerMoves.add(m);
				}
				else {
					this.pawnMoves.add(m);
				}
			}
		}
		
		
	
		
		
	}
	

}
