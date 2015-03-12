public class GameBoard
{
	private char[] position;
	private final char EMPTY = ' ';
	private final char MARK1 = 'X';
	private final char MARK2 = 'O';
	private int[][] rowRecord;
	private int[][] colRecord;
	private int[] addRecord;
	private int[] divRecord;

	GameBoard()
	{
		position = new char[9];
		rowRecord = new int [3][2];
		colRecord = new int [3][2];
		addRecord = new int [2];
	        divRecord = new int [2];
		for(int i = 0; i < 9; i++) 
			position[i] = EMPTY;
	}

	public int gameBoardMark(int player, int row, int col)
	{
		/*
		 *  player = 0 -> player mark is "X"
		 *  player = 1 -> player mark is "O"
		 */
		char mark = (player == 0) ? MARK1 : MARK2;
		try {
			if(position[row * 3 + col] != ' ')
				return 0;

			position[row * 3 + col] = mark;
			
			rowRecord[row][player]++;
			colRecord[col][player]++;

			if( row - col == 0)
				divRecord[player]++;
			
			if( row + col == 2)
				addRecord[player]++;

		} catch ( ArrayIndexOutOfBoundsException e ) {
			System.err.printf("%s row = %d, col = %d","In valid index\n", row, col);
		}
		return 1;
	}

	public int checkWinner()
	{
		/*
		 * ret = 0 -> there's no winner
		 * ret = 1 -> player1 (X) wins the game
		 * ret = 2 -> player2 (O) wins the game
		 */
		for(int player = 0; player < 2; player++)
			if(divRecord[player] == 3 || addRecord[player] == 3)
				return player + 1;

		for(int row = 0; row < 3; row++)
			for(int player = 0; player < 2; player++)
				if(rowRecord[row][player] == 3 || colRecord[row][player] == 3)
					return player + 1;
		
		return 0;	
	}

	public void printGameBoard()
	{
		for(int row = 0 ; row < 3; row ++) {
			System.out.printf("\n-------------\n");
			System.out.print("| ");
			for(int col = 0; col < 3; col++) {
				System.out.printf("%c | ", position[row * 3 +col]);
			}
		}
		System.out.printf("\n-------------\n");
	}
}
