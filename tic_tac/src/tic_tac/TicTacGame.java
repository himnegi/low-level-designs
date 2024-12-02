package tic_tac;

import java.util.*;

public class TicTacGame {
	public List<Players> players;
	public Board board;
	Scanner scanner = new Scanner(System.in);

	public Players startGame() {

		int row;
		int column;
		intializeMatch();
		System.out.println("intializing board");
		board.intitialize();
		int count = 0;
		Players player = players.get(0);
		while (true) {

			System.out.println("please enter row and column for player " + player.getName());
			row = scanner.nextInt();
			column = scanner.nextInt();
			boolean isValidated = board.validateCoordinates(row, column);
			if (isValidated == false) {
				System.out.println(" coordinates are either ocupied or out of box retry again " + player.getName());
				continue;

			}
			boolean isWinner = checkForWinner();
			if (isWinner == true)
				return player;

			board.updateBoard(row, column, player.getPeiceType().charAt(0));
			board.printBoard();
			//
			System.out.println("count" + count);
			count++;
			player = SwitchPlayers(count, players, board.getSize() - 1);

		}
	}

	private boolean checkForWinner() {

		return false;
	}

	private Players SwitchPlayers(int count, List<Players> players, int size) {
		System.out.println("count" + count);
		int index = count % size;
		return players.get(index);
	}

	public void intializeMatch() {
		System.out.println("enter no of players ");
		int inputNumber = scanner.nextInt();
		board = new Board(inputNumber + 1);
		players = new ArrayList<Players>();
		for (int i = 0; i < inputNumber; i++) {
			System.out.println("Enter the name of player " + (i + 1) + ":");
			String playerName = scanner.next();
			System.out.println("Enter the character for player :");
			String peice = scanner.next();
			Players p = new Players(playerName, peice);
			players.add(p);

		}
	}
}
