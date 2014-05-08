import java.util.LinkedList;
import java.util.Random;


public class Board {
	private int[][] board;
	private Random rnd;
	private LinkedList<Pair> emptyEntries;

	public Board(int n) {
		this.board = new int[n][n];
		this.emptyEntries = new LinkedList<>();
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				this.board[i][j] = 0;
				this.emptyEntries.addLast(new Pair(i, j));
			}
		}
		
		this.rnd = new Random();
		
		for (int i = 0; i < 2; i++) {	
			this.addNewVal();
		}
	}
	
	void addNewVal() {
		int val = this.rnd.nextInt(4) < 3 ? 2 : 4;
		int index = this.rnd.nextInt(this.emptyEntries.size());
		Pair p = this.emptyEntries.remove(index);
		this.board[p.x][p.y] = val;
	}
	
	void updateEmptyEntries() {
		this.emptyEntries = new LinkedList<>();
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 0) this.emptyEntries.addLast(new Pair(i, j));
			}
		}
	}
	
	int[][] get()
	{
		return board;
	}
	
	@Override
	public String toString() {
		String res = "";
		int n = board.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < board[i].length; j++) {
				res = res + "|\t" + board[i][j] + "\t";
				
				if (j == n - 1) res += "|\n";
			}
		}
		
		return res;
	}

	boolean isFull()
	{
		return emptyEntries.isEmpty();
	}
}
