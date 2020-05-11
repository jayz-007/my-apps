package tictactoe.model;

public class GameLogic {
	String[][] board = new String[3][3];
	private int endgame = 0;
	private int flag = 0;

	public GameLogic() {
		createBoard();
	}

	public void createBoard() {
		int num = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = num++ + " ";

			}
		}
	}

	public boolean drawMyCode(Player p, String num) {
		int row = Integer.parseInt(num);
		int column = Integer.parseInt(num);
		row = row / 3;
		column = column % 3;
		num = num.concat(" ");
		String number = board[row][column];
		if (number.equals(num)) {
			incrementFlag();
			board[row][column] = number.replace(number, p.getPlayerCode() + " ");
			return true;
			
			
		}
		return false;
	}

	public void checkSequence(int num, Player p) {
		int row = num / 3;
		int column = num % 3;
		String str = board[row][column];
		String PlayerCode = p.getPlayerCode() + " ";
		switch (num) {
		case 0:
			if (checkRight(row, column, PlayerCode)) {
				if (checkRight(row, ++column, PlayerCode)) {
					endgame = 1;
					break;

				}
				--column;
			}
			if (checkDown(row, column, PlayerCode)) {
				if (checkDown(++row, column, PlayerCode)) {
					endgame = 1;
					break;
				}
				--row;
			}
			if (checkDiagonalDownRight(row, column, PlayerCode)) {
				if (checkDiagonalDownRight(++row, ++column, PlayerCode)) {
					endgame = 1;
					break;
				}
				--row;
				--column;

			}
			break;
		case 1:
			if (checkLeft(row, column, PlayerCode)) {
				if (checkRight(row, column, PlayerCode)) {
					endgame = 1;
					break;
				}
			}
			if (checkDown(row, column, PlayerCode)) {
				if (checkDown(++row, column, PlayerCode)) {
					endgame = 1;
					break;
				}
				--row;
			}
			break;
		case 2:
			if (checkLeft(row, column, PlayerCode)) {
				if (checkLeft(row, --column, PlayerCode)) {
					System.out.println("endgame is 1");
					endgame = 1;
					break;
				}
				++column;
			}
			if (checkDown(row, column, PlayerCode)) {
				if (checkDown(++row, column, PlayerCode)) {
					endgame = 1;
					break;
				}
				--row;
			}
			if (checkDiagonalDownLeft(row, column, PlayerCode)) {
				if (checkDiagonalDownLeft(++row, --column, PlayerCode)) {
					endgame = 1;
					break;
				}
				--row;++column;

			}
			break;
		case 3:
			if (checkUp(row, column, PlayerCode)) {
				if (checkDown(row, column, PlayerCode)) {
					endgame = 1;
					break;
				}
			}
			if (checkRight(row, column, PlayerCode)) {
				if (checkRight(row, ++column, PlayerCode)) {
					endgame = 1;
					break;
				}
				--column;
			}
			break;
		case 4:
			if (checkUp(row, column, PlayerCode)) {
				if (checkDown(row, column, PlayerCode)) {
					endgame = 1;
					break;
				}
			}
			if (checkRight(row, column, PlayerCode)) {
				if (checkLeft(row, column, PlayerCode)) {
					endgame = 1;
					break;
				}
			}
			if (checkDiagonalUpRight(row, column, PlayerCode)) {
				if (checkDiagonalDownLeft(row, column, PlayerCode)) {
					endgame = 1;
					break;
				}
			}
			if (checkDiagonalUpLeft(row, column, PlayerCode)) {
				if (checkDiagonalDownRight(row, column, PlayerCode)) {
					endgame = 1;
					break;
				}
			}
			break;

		case 5:
			if (checkLeft(row, column, PlayerCode)) {
				if (checkLeft(row, --column, PlayerCode)) {
					endgame = 1;
					break;
				}
				++column;
			}
			if (checkUp(row, column, PlayerCode)) {
				if (checkDown(row, column, PlayerCode)) {
					endgame = 1;
					break;
				}
			}
			break;
		case 6:
			if (checkRight(row, column, PlayerCode)) {
				if (checkRight(row, ++column, PlayerCode)) {
					endgame = 1;
					break;
				}
				--column;
			}
			if (checkUp(row, column, PlayerCode)) {
				if (checkUp(--row, column, PlayerCode)) {
					endgame = 1;
					break;
				}
				++row;
			}
			if (checkDiagonalUpRight(row, column, PlayerCode)) {
				if (checkDiagonalUpRight(--row, ++column, PlayerCode)) {
					endgame = 1;
					break;
				}
				++row;--column;

			}
			break;
		case 7:
			if (checkLeft(row, column, PlayerCode)) {
				if (checkRight(row, column, PlayerCode)) {
					endgame = 1;
					break;
				}
			}
			if (checkUp(row, column, PlayerCode)) {
				if (checkUp(--row, column, PlayerCode)) {
					endgame = 1;
					break;
				}
				++row;
			}
			break;

		case 8:
			if (checkLeft(row, column, PlayerCode)) {
				if (checkLeft(row, --column, PlayerCode)) {
					endgame = 1;
					break;
				}
				++column;
			}
			if (checkUp(row, column, PlayerCode)) {
				if (checkUp(--row, column, PlayerCode)) {
					endgame = 1;
					break;
				}
				++row;
			}
			if (checkDiagonalUpLeft(row, column, PlayerCode)) {
				if (checkDiagonalUpLeft(--row, --column, PlayerCode)) {
					endgame = 1;
					break;
				}
				++row;++column;

			}
			break;

		default:
			break;
		}

	}

	public boolean checkUp(int row, int column, String PlayerCode) {
		return (board[--row][column].equals(PlayerCode));

	}

	public boolean checkDown(int row, int column, String PlayerCode) {
		return (board[++row][column].equals(PlayerCode));
	}

	public boolean checkRight(int row, int column, String PlayerCode) {
		return (board[row][++column].equals(PlayerCode));

	}

	public boolean checkLeft(int row, int column, String PlayerCode) {
		return (board[row][--column].equals(PlayerCode));

	}

	public boolean checkDiagonalUpLeft(int row, int column, String PlayerCode) {
		return (board[--row][--column].equals(PlayerCode));

	}

	public boolean checkDiagonalUpRight(int row, int column, String PlayerCode) {
		return (board[--row][++column].equals(PlayerCode));

	}

	public boolean checkDiagonalDownRight(int row, int column, String PlayerCode) {
		return (board[++row][++column].equals(PlayerCode));

	}

	public boolean checkDiagonalDownLeft(int row, int column, String PlayerCode) {
		return (board[++row][--column].equals(PlayerCode));

	}

	public int getEndGame() {
		return endgame;
	}

	public String[][] getBoard() {
		return board;
	}
	public int getFlag() {
		return flag;
		
	}
	public void incrementFlag() {
		this.flag++;
	}
	public void resetFlag() {
		this.flag = 0;
		this.endgame=1;
	}


}
