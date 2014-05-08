
public class Validation {

	static boolean hasMove(Board board) {
		return !board.isFull() 
				|| twoHorizontalEqualEntries(board.get()) 
				|| twoVerticalEqualEntries(board.get());
	}
	
	static boolean legalMove(int[][] board, String move) {
		switch(move.toUpperCase().charAt(0)) {
		case 'D':
			return twoVerticalEqualEntries(board) || emptySpaceForD(board);
		case 'U':
			return twoVerticalEqualEntries(board) || emptySpaceForU(board);
		case 'R':
			return twoHorizontalEqualEntries(board) || emptySpaceForR(board);
		case 'L':
			return twoHorizontalEqualEntries(board) || emptySpaceForL(board);
		default:
			return false;
		}
	}
	
	static boolean check2048(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 2048) return true;
			}
		}
		return false;
	}
	
	private static boolean twoHorizontalEqualEntries(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length - 1; j++) {
				if (board[i][j] != 0 && board[i][j] == board[i][j + 1]) return true;
			}
		}
		return false;
	}

	private static boolean twoVerticalEqualEntries(int[][] board) {
		for (int i = 0; i < board.length - 1; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != 0 && board[i][j] == board[i + 1][j]) return true;
			}
		}
		return false;
	}
	
	private static boolean emptySpaceForL(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			int j;
			for (j = board[i].length - 1; j >= 0; j--) {
				if (board[i][j] != 0) break;
			}
			for (j--; j >= 0; j--) {
				if (board[i][j] == 0) return true;
			}
		}
		return false;
	}

	private static boolean emptySpaceForR(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			int j;
			for (j = 0; j < board[i].length; j++) {
				if (board[i][j] != 0) break;
			}
			for (j++; j < board[i].length; j++) {
				if (board[i][j] == 0) return true;
			}
		}
		return false;
	}

	private static boolean emptySpaceForU(int[][] board) {
		for (int j = 0; j < board[0].length; j++) {
			int i;
			for (i = board.length - 1; i >= 0; i--) {
				if (board[i][j] != 0) break;
			}
			for (i--; i >= 0; i--) {
				if (board[i][j] == 0) return true;
			}
		}
		return false;
	}

	private static boolean emptySpaceForD(int[][] board) {
		for (int j = 0; j < board[0].length; j++) {
			int i;
			for (i = 0; i < board.length; i++) {
				if (board[i][j] != 0) break;
			}
			for (i++; i < board.length; i++) {
				if (board[i][j] == 0) return true;
			}
		}
		return false;
	}
}
