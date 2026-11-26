package com.array;

import java.util.Scanner;

public class TicTocToe {

	static char[][] board = new char[3][3];
	static char player = 'X';
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = ' ';
			}
		}

		System.out.println("start the game");
		while (true) {
			printboard();
			System.out.println(player + "s turn!!");
			System.out.println("please choose the row (0-2)");
			int row = s.nextInt();
			System.out.println("please choose the col (0-2)");
			int col = s.nextInt();
			System.out.println("(" + row + "," + col + ")");
			if (row < 0 | row > 2 | col < 0 | col > 2) {
				System.out.println("Invalid Move!!");
				continue;
			}

			board[row][col] = player;
			if (checkwinner()) {
				System.out.print(player + "is winner");
				printboard();
				break;
			}
			if(isboardisfull()) {
				System.out.println("WOWW board is fulll!!");
				printboard();
				break;
			}
				player = (player == 'X') ? 'O' : 'X';
			}
		}
	

	private static boolean isboardisfull() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				if(board[i][j]==' ') {
					return false;
				}
			}
		}
		return true;
		}


	private static boolean checkwinner() {
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
				return true;
			}
		}
		for (int i = 0; i < board.length; i++) {
			if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
				return true;
			}
		}
		if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			return true;
		}
		if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
			return true;
		}

		return false;
	}

	private static void printboard() {
		for (int i = 0; i < board.length; i++) {
			System.out.print(" | ");
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " | ");

			}
			System.out.println();

			System.out.println("---------------");

		}
	}

}
