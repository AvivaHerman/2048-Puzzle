
class MoveRight extends Move {

	MoveRight(int handle, int[][] board, Score score) {
		super(handle, board, score);
	}

	@Override
	void merge() {
		for (int j = board[handle].length - 1; j > 0; j--) {
			if (board[handle][j] == board[handle][j - 1]) {
				board[handle][j] = board[handle][j] * 2;
				myScore += board[handle][j];
				board[handle][j - 1] = 0;
			}
		}
	}

	@Override
	void shrink() {
		int nextIndex = board[handle].length - 1;
		for (int j = board[handle].length - 1; j >= 0; j--) {
			if (board[handle][j] != 0) {
				board[handle][nextIndex] = board[handle][j];
				if (j < nextIndex) board[handle][j] = 0;
				nextIndex--;
			}
		}
	}

}
