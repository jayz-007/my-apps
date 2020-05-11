package com.snl.model.test;

public class LaunchGame {

	public static void main(String args[]) {
		String[][] h = new String[10][10];
		h[0][0] = "h";
		addspaces(h, 0, 0);
		addspaces(h, 0, 0);
	
		add(32, h, 0, 0, 90);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(h[i][j] + " |");
			}
			System.out.println();
		}

	}

	public static void add(int num, String h[][], int row, int column, int insert) {
		for (int i = 0; i <= 1; i++) {
			if (num / 10 == 0) {
				column = num;
				h[row][column] = String.valueOf(insert);
			} else
				row = num / 10;
			column = num % 10;
			h[row][column - 1] = String.valueOf(insert);

		}
	}

	public static void addspaces(String h[][], int row, int column) {
		int length = h[row][column].length();
		String[] temp = h[row][column].split(" ");
		h[row][column] = temp[0] + "*";
		while (true) {
			if (length - 2 < 4)
				h[row][column] = h[row][column] + " ";
			else
				break;
		}

	}

}
