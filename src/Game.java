import java.util.Scanner;


public class Game {
	private Board board;
	private Thread[] threads;
	private String move;
	private Score score;
	private boolean win;
	
	public Game(int n) {
		board = new Board(n);
		threads  = new Thread[n];
		score = new Score();
		win = false;
	}
	
	public void start()
	{
		Scanner in = new Scanner(System.in);

		while (Validation.hasMove(board)) {
			System.out.println(board);
			
			chooseMove(in);
			makeMove();
			board.updateEmptyEntries();
			board.addNewVal();

			if (Validation.check2048(board.get())) {
				win = true;
				System.out.println(this);
				in.close();
				return;
			}
		}
		
		in.close();
		System.out.println(this);
	}

	private void chooseMove(Scanner in) {
		do {
			System.out.println("Please choose the next move: left(L), right(R), up(U), down(D)");
			move = in.next();
		} while (!Validation.legalMove(board.get(), move));
		
		switch(move.toUpperCase().charAt(0)) {
		case '8':
		case 'U':
			for (int i = 0; i < threads.length; i++) {
				threads[i] = new Thread(new MoveUp(i, board.get(), score));
			}
			break;
		case '2':
		case 'D':
			for (int i = 0; i < threads.length; i++) {
				threads[i] = new Thread(new MoveDown(i, board.get(), score));
			}
			break;
		case '4':
		case 'L':
			for (int i = 0; i < threads.length; i++) {
				threads[i] = new Thread(new MoveLeft(i, board.get(), score));
			}
			break;
		case '6':
		case 'R':
			for (int i = 0; i < threads.length; i++) {
				threads[i] = new Thread(new MoveRight(i, board.get(), score));
			}
			break;
		default:
			System.out.println("Not a legal move!");
			break;
		}
	}

	private void makeMove() {
		score.addMove();
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				i--;
				continue;
			}
		}
	}
	
	public static void main(String[] args) {
		Game game = new Game(4);
		game.start();
	}

	@Override
	public String toString() {
		return "" + board + score + (win ? "You Won!" : "Game Over");
	}
}
