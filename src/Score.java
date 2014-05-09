
class Score {
	private int totalScore;
	private int moves;
	
	Score() {
		totalScore = 0;
		moves = 0;
	}
	
	void addMove()
	{
		moves++;
	}
	
	synchronized void addScore(int score) 
	{
		totalScore += score;
	}

	@Override
	public String toString() {
		return "Your Score: " + totalScore + "\nnumber of moves: " + moves + "\n";
	}
}
