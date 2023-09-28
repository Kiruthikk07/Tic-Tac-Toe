import java.util.Scanner;

public class TicTacToe {
	public static void printBoard(char[][] board) {
		System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
		System.out.println("--+---+--");
		System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
		System.out.println("--+---+--");
		System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
	}

	public static boolean haveWon(char[][] board, char player) {
		for (int row = 0; row < board.length; row++) {
			if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
				return true;
			}
			if (board[0][row] == player && board[1][row] == player && board[2][row] == player) {
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

	public static boolean isValid(char[][] board, int move) {
		switch (move) {
		case 1:
			return board[0][0] == ' ';
		case 2:
			return board[0][1] == ' ';

		case 3:
			return board[0][2] == ' ';

		case 4:
			return board[1][0] == ' ';

		case 5:
			return board[1][1] == ' ';

		case 6:
			return board[1][2] == ' ';

		case 7:
			return board[2][0] == ' ';

		case 8:
			return board[2][1] == ' ';

		case 9:
			return board[2][2] == ' ';
		}
		return false;
	}

	public static boolean haveDrawn(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[3][3];
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = ' ';
			}
		}

		char player = 'X';
		boolean gameOver = false;
		boolean draw = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to Tic-Tac-Toe!");

		while (!gameOver && !draw) {
			printBoard(board);
			System.out.println("Player " + player + "'s turn.");
			System.out.print("Enter a move (1-9): ");
			int move = sc.nextInt();
			if (move <= 9 && move >= 1) {
				if (isValid(board, move)) {

					switch (move) {
					case 1:

						board[0][0] = player;

						break;
					case 2:

						board[0][1] = player;

						break;
					case 3:

						board[0][2] = player;

						break;
					case 4:

						board[1][0] = player;

						break;
					case 5:

						board[1][1] = player;

						break;
					case 6:

						board[1][2] = player;

						break;
					case 7:

						board[2][0] = player;

						break;
					case 8:

						board[2][1] = player;

						break;
					case 9:

						board[2][2] = player;

						break;
					}
					gameOver = haveWon(board, player);
					draw = haveDrawn(board);
					if (gameOver) {
						printBoard(board);
						System.out.println("-----------------\nPlayer " + player + " has won!\n-----------------");
					}

					else if (draw) {
						printBoard(board);
						System.out.println("--------------\nGame is drawn!\n--------------");
					}

					else {
						player = (player == 'X') ? 'O' : 'X';
					}
				} else {
					System.out.println("The place is already occupied. Try again!");
				}

			} else {
				System.out.println("Invalid input. Enter a number from 1 to 9.");
			}

		}
		sc.close();

	}

}
