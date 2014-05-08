
public abstract class Move implements Runnable {

	int handle;
	int[][] board;

	public Move(int handle, int[][] board) {
		this.handle = handle;
		this.board = board;
	}
	
	@Override
	public void run() {
		shrink();
		merge();
		shrink();
	}

	abstract void merge();
	abstract void shrink();
}
