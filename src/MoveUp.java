
class MoveUp extends Move {

	MoveUp(int handle, int[][] board, Score score) {
		super(handle, board, score);
	}

	@Override
	void merge() {
		for (int i = 0; i < board.length - 1; i++) {
			if (board[i][handle] == board[i + 1][handle]) {
				board[i][handle] = board[i][handle] * 2;
				myScore += board[i][handle];
				board[i + 1][handle] = 0;
			}
		}
	}

	@Override
	void shrink() {
		int nextIndex = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i][handle] != 0) {
				board[nextIndex][handle] = board[i][handle];
				if (i > nextIndex) board[i][handle] = 0;
				nextIndex++;
			}
		}
	}

}
