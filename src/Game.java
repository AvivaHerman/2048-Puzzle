import java.util.Scanner;


public class Game {
	private Board board;
	private Thread[] left;
	private Thread[] right;
	private Thread[] up;
	private Thread[] down;
	
	public Game(int n) {
		board = new Board(n);
		
		left  = new Thread[n];
		right = new Thread[n];
		up 	  = new Thread[n];
		down  = new Thread[n];
	}
	
	public void start()
	{
		String move;
		Scanner in = new Scanner(System.in);
		  		
		while (Validation.hasMove(this.board)) {
			System.out.println(this.board);
			
			do {
				System.out.println("\nPlease choose the next move: left(L), right(R), up(U), down(D)");
				move = in.next();
			} while (!Validation.legalMove(this.board.get(), move));
			
			switch(move.toUpperCase().charAt(0)) {
			case 'U':
				for (int i = 0; i < up.length; i++) {
					up[i] = new Thread(new MoveUp(i, board.get()));
				}
				play(up);
				break;
			case 'D':
				for (int i = 0; i < down.length; i++) {
					down[i] = new Thread(new MoveDown(i, board.get()));
				}
				play(down);
				break;
			case 'L':
				for (int i = 0; i < left.length; i++) {
					left[i] = new Thread(new MoveLeft(i, board.get()));
				}
				play(left);
				break;
			case 'R':
				for (int i = 0; i < right.length; i++) {
					right[i] = new Thread(new MoveRight(i, board.get()));
				}
				play(right);
				break;
			default:
				System.out.println("Not a legal move!");
				break;
			}
			
			
			this.board.updateEmptyEntries();
			this.board.addNewVal();

			if (Validation.check2048(this.board.get())) {
				System.out.println(this.board);
				System.out.println("You Won!");
				in.close();
				return;
			}
		}
		
		in.close();
		System.out.println("Game Over");
	}

	private void play(Thread[] move) {
		for (int i = 0; i < move.length; i++) {
			move[i].start();
		}
		
		for (int i = 0; i < move.length; i++) {
			try {
				move[i].join();
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
}
