
abstract class Move implements Runnable {

	int handle;
	int[][] board;
	Score score;
	int myScore;

	Move(int handle, int[][] board, Score score) {
		this.handle = handle;
		this.board = board;
		this.score = score;
		this.myScore = 0;
	}
	
	@Override
	public void run() {
		shrink();
		merge();
		shrink();
		score.addScore(myScore);
	}

	abstract void merge();
	abstract void shrink();
}
