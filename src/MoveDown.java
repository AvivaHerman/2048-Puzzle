
class MoveDown extends Move {

	MoveDown(int handle, int[][] board, Score score) {
		super(handle, board, score);
	}

	@Override
	void merge() {
		for (int i = board.length - 1; i > 0; i--) {
			if (board[i][handle] == board[i - 1][handle]) {
				board[i][handle] = board[i][handle] * 2;
				myScore += board[i][handle];
				board[i - 1][handle] = 0;
			}
		}
	}

	@Override
	void shrink() {
		int nextIndex = board.length - 1;
		for (int i = board.length - 1; i >= 0; i--) {
			if (board[i][handle] != 0) {
				board[nextIndex][handle] = board[i][handle];
				if (i < nextIndex) board[i][handle] = 0;
				nextIndex--;
			}
		}
	}

}
