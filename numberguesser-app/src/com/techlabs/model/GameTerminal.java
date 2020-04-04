package com.techlabs.model;

import java.util.Scanner;

public class GameTerminal {
	private String quit = "no";
	private int result;
	private final int GREATER = 1;
	private final int SMALLER = 2;
	private final int EQUALS = 3;

	public void startGame() {
		Game newgame = new Game();
		newgame.generateRandomn();
		do {
			guessNo(newgame);
			checkGuessedNum(newgame);

		} while (this.quit == "no");

	}

	public void checkUserAnswer() {

		System.out.println("Do you want to quit? yes or no");
		Scanner sc = new Scanner(System.in);
		String decission = sc.next();
		switch (decission) {
		case "no":
			quit = "no";
			break;
		case "yes":
			quit = "yes";
			break;
		}

	}

	public void checkGuessedNum(Game newgame) {
		result = newgame.checkGuessedNo();
		switch (result) {
		case GREATER:
			System.out.println("Number is greater than actual value");
			break;
		case SMALLER:
			System.out.println("Number is less than actual value");
			break;
		case EQUALS:
			System.out.println("Number is equal to actual value \nNumber of guesses made: " + newgame.getGuessMade());

			checkUserAnswer();
			newgame.generateRandomn();
			newgame.resetGuessMade();
			
		}
	}

	public void guessNo(Game newgame) {
		System.out.println("Guess the number");
		Scanner sc = new Scanner(System.in);
		newgame.guessNo(sc.nextInt());

	}

}
