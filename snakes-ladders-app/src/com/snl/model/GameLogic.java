package com.snl.model;

public class GameLogic {
	private String[][] board;

	public GameLogic() {
		this.board= createBoard();

	}
	
	public int rolldice() {
		int diceX=(int)(Math.random()*6+1);
		return diceX;
	}

	private String[][] createBoard() {
		String[][] board = new String[10][10];

		Snake minusTwenty = new Snake(20, 24, board);
		Snake minusThirty = new Snake(30, 56, board);
		Snake minusFortyone = new Snake(41, 88, board);
		Snake minusFortyFour = new Snake(44, 99, board);
		Snake minusTwentynine = new Snake(29, 72, board);
		
		Ladder plusEleven = new Ladder(11, board, 2);
		Ladder plusThirtytwo = new Ladder(32, board, 27);
		Ladder plusFiftyNine = new Ladder (59, board, 34);
		
		return board;
	}
	
	public void checkSquare(int dice,Player p) {
		int position = dice + p.getPlayerPosition();
		if(board[getRow(position)][getColumn(position)].contains("<--"))
			
		
	}
	
	public int getRow(int position) {
		
		 int row = position/10;
		 return row;
		
	}
	
	public int getColumn(int position) {
		
		 int column = position%10;
		 return column;
		
	}
}
