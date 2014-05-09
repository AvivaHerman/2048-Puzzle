
class MoveLeft extends Move {

	MoveLeft(int handle, int[][] board, Score score) {
		super(handle, board, score);
	}

	@Override
	void merge() {
		for (int j = 0; j < board[handle].length - 1; j++) {
			if (board[handle][j] == board[handle][j + 1]) {
				board[handle][j] = board[handle][j] * 2;
				myScore += board[handle][j];
				board[handle][j + 1] = 0;
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
