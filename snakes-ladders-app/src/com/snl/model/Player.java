package com.snl.model;

public class Player {
	private String playerName;
	private String playerCode;
	private int playerPosition;

	public String getCode() {
		return playerCode;
	}

	public String getplayerName() {
		return playerName;
	}

	public int getPlayerPosition() {
		return playerPosition;
	}

	public void updatePlayerPosition(int playerPosition, String[][] board) {
		this.playerPosition = playerPosition;
		setPosition(board, this.playerPosition);
	}

	private void setPosition(String board[][], int position) {
		int row = this.playerPosition / 10;
		int column = this.playerPosition % 10;
		for (int i = 0; i <= 1; i++) {
			if (position / 10 == 0) {
				column = position;
				String temp = board[row][column];
				board[row][column] = temp + getplayerName();
			} else {
				row = position / 10;
				column = position % 10;
				String temp = board[row][column];
				board[row][column] = temp + getplayerName();

			}
		}
	}

}
