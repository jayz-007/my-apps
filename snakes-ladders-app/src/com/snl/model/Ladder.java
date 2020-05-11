package com.snl.model;

public class Ladder {
	private int goUp;

	public Ladder(int goUp,String board[][],int position) {
		this.goUp = goUp;
		setPosition(board, position);
	}

	public void climbLadder(Player player,String board[][]) {
		player.updatePlayerPosition(player.getPlayerPosition() + goUp, board);
	}
	private void setPosition(String board[][],  int position) {
		int row = position / 10;
		int column = position % 10;
		for (int i = 0; i <= 1; i++) {
			if (position / 10 == 0) {
				column = position;
				board[row][column] = "/";
			} else
				row = position / 10;
			column = position % 10;
			board[row][column - 1] = "/";

		}
	}

}
