package piece;

import java.util.ArrayList;
import java.awt.Point;
import interfaces.IPiece;

public abstract class Piece implements IPiece {
	
	public enum Color {
        WHITE, BLACK
    }
	
	
	private Type type;
	protected Color color;
	protected boolean moved;
	protected int value;
	
	
	public Piece(Type type, Color color, int value) {
		super();
		this.type = type;
		this.color = color;
		this.value = value;
		moved = false;
	}


	public Type getType() {
		return type;
	}
	
	 public Color getColor() {
        return color;
	 }
	
	public int getValue() {
		return value;
	}
	
	abstract public Collection<Point> getLegalMoves();
	
}
