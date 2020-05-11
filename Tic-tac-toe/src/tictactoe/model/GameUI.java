package tictactoe.model;

import java.util.Scanner;

public class GameUI {
	private String comtinueGame = "yes";

	public void startGame() {
		Scanner player = new Scanner(System.in);
		System.out.println("Enter player1 name:");
		Player player1 = new Player(player.nextLine(), "X");
		System.out.println("Enter player2 name:");
		Player player2 = new Player(player.nextLine(), "O");
		GameLogic newGame = new GameLogic();
		while (comtinueGame.equals("yes")) {
			Scanner line = new Scanner(System.in);
			if (checkGameStatus(player1, line, newGame) == false) {
				checkGameStatus(player2, line, newGame);
			}
			newGame = resetBoard(newGame);
			

		}

	}

	public boolean dsiplayPlayerGUI(Player player, Scanner line, GameLogic newGame) {
		if (newGame.getFlag() < 9) {
			newGame.incrementFlag();
			System.out.println("___________________");
			displayBoard(newGame);
			System.out.println(player.getPlayerName() + " choose a number to draw");
			String num = line.nextLine();
			if (newGame.drawMyCode(player, num) == false) {
				System.err.println("The place is already marked \n"+ player.getPlayerName()+" choose other number");
				dsiplayPlayerGUI(player, line, newGame);
			}
			newGame.checkSequence(Integer.parseInt(num), player);
			if (newGame.getEndGame() == 1) {
				System.out.println("___________________");
				displayWinningSequence(newGame, player.getPlayerCode() + " ");
				System.err.println(player.getPlayerName() + " won the game");

				return true;
			}
		}else {
			System.err.println("Game is a draw");
			newGame.resetFlag();
			return true;
		}
		return false;
	}

	public boolean checkGameStatus(Player player, Scanner line, GameLogic newGame) {
		if (dsiplayPlayerGUI(player, line, newGame)) {
			System.out.println("Do you want to play another Game?yes or no ");
			this.comtinueGame = line.nextLine().toLowerCase();
			
			return true;

		}
		return false;
	}

	public void displayBoard(GameLogic newGame) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(newGame.getBoard()[i][j] + " ");
			}
			System.out.println();
		}

	}

	public void displayWinningSequence(GameLogic newGame, String str) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (str.contentEquals(newGame.getBoard()[i][j]))
					System.out.print(str);
				else
					System.out.print("* ");
			}
			System.out.println();
		}

	}

	public GameLogic resetBoard(GameLogic newGame) {
		if (newGame.getEndGame() == 1) {
			GameLogic newgame1 = new GameLogic();
			newGame = newgame1;
			newgame1 = null;
			return newGame;
		}
		return newGame;
	}

}
