package com.snl.model;

public class Snake {
	private int goDown;

	public Snake(int goDown, int position, String board[][]) {
		this.goDown = goDown;
		setPosition(board, position);
	}

	public void snakeEats(Player p,String board[][]) {
		p.updatePlayerPosition(p.getPlayerPosition() - goDown, board);

	}

	private void setPosition(String board[][], int position) {
		int row = position / 10;
		int column = position % 10;
		for (int i = 0; i <= 1; i++) {
			if (position / 10 == 0) {
				column = position;
				board[row][column] = "<--";
			} else
				row = position / 10;
			column = position % 10;
			board[row][column - 1] = "<--";

		}
	}

}
