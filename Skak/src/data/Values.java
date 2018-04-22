package data;

public class Values {
	//Values to change.
	
	//Move values
	public static int SMALLTAKEBIG = 1000;	//Value added to move if piece of lesser value takes a piece of higher value. e.g. pawn takes rook. 
	public static int SETCHECKMATE = 10000;
	public static int CENTERPAWN = 10;		//The more centered a pawn is on the x-axis, the better. (A to H)
	public static int KINGCASTLE = 100000000;	//Castling is always good.
	
	
	//The value of the chess pieces
	public static int QUEEN = 9;
	public static int KING = Integer.MAX_VALUE;
	public static int BISHOP = 3;
	public static int KNIGHT = 3;
	public static int PAWN = 1;
	public static int ROOK = 5;
	
	
	

}
