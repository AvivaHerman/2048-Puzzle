
public class MoveLeft extends Move {

	public MoveLeft(int handle, int[][] board) {
		super(handle, board);
	}

	@Override
	void merge() {
		for (int j = 1; j < board[handle].length; j++) {
			if (board[handle][j] == board[handle][j - 1]) {
				board[handle][j - 1] = board[handle][j - 1] * 2;
				board[handle][j] = 0;
			}
		}
	}

	@Override
	void shrink() {
		int nextIndex = 0;
		for (int j = 0; j < board[handle].length; j++) {
			if (board[handle][j] != 0) {
				board[handle][nextIndex] = board[handle][j];
				if (j > nextIndex) board[handle][j] = 0;
				nextIndex++;
			}
		}
	}

}
