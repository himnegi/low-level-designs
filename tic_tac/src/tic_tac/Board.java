package tic_tac;

public class Board {
	private int size;
	private char[][] boardSize;

	public Board(int size) {
		this.size = size;
		boardSize = new char[size][size];
		System.out.println("board intialize with size " + size);
	}

	public int getSize() {
		return this.size;
	}

	public char[][] getBoardSize() {
		return this.boardSize;
	}

	public void printBoard() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(boardSize[i][j] + "| ");
			}
			System.out.println();
		}
	}

	public void updateBoard(int row, int column, char peice) {
		this.boardSize[row][column] = peice;

	}

	public boolean validateCoordinates(int row, int column) {

		if (row > this.size || column > this.size) {
			System.out.println("code 0");
			System.out.println("size" + this.size);
			return false;
		} else if (this.boardSize[row][column] != ' ') {
			System.out.println("code 1");
			return false;
		}
		return true;

	}

	public void intitialize() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				boardSize[i][j] = ' ';
			}
		}
	}

}
