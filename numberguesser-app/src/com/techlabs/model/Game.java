package com.techlabs.model;

import java.util.Random;
import java.util.Scanner;

public class Game {
	private int guessno;
	private int randomno;
	private int guessesmade = 0;

	public void generateRandomn() {
		Random rn = new Random();
		randomno = rn.nextInt(100);

	}

	public void guessNo(Integer guessno) {

		this.guessno = guessno;
	}

	public int checkGuessedNo() {
		incrementguessMade();
		if (guessno > randomno) {

			return 1;
		}
		if (guessno < randomno) {

			return 2;
		} else if (guessno == randomno) {

			return 3;
		}
		return 0;
	}

	public void incrementguessMade() {
		guessesmade++;
	}

	public void resetGuessMade() {
		guessesmade = 0;

	}

	public int getGuessMade() {
		return guessesmade;
	}

}
