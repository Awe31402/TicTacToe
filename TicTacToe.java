import java.util.Scanner;

public class TicTacToe
{
	public static void main(String[] args)
	{
		int player = 0;
		int winner = 0;
		int current = 0;
		int row, col;

		Scanner scanner = new Scanner(System.in);
		GameBoard game = new GameBoard();
		game.printGameBoard();

		while(current < 9 && winner == 0)
		{
			do {
				System.out.printf("player %d -> Input row: ",player + 1);
				row = scanner.nextInt();
				System.out.printf("player %d -> Input col: ",player + 1);
				col = scanner.nextInt();
			} while(game.gameBoardMark(player, row, col) == 0);
			
			game.printGameBoard();
			winner = game.checkWinner();
			current++;
			player = (player + 1) % 2;
		}

		if(winner != 0)
			System.out.printf("\nThe winner is player %d!!\n", winner);
		else
			System.out.printf("\nDraw game!!");
	}
}
