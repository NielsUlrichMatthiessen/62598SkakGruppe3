package piece;

import java.util.ArrayList;

public class King extends Piece {
	
	private boolean check;		//King checked (I skak)
	private static int value = Integer.MAX_VALUE;
	
	
	
	
	
	public King() {
		super(Type.King, value);
		
		
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	
	

}
