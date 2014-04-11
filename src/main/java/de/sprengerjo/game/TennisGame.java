package de.sprengerjo.game;

/**
 * Created with IntelliJ IDEA. User: cojo Date: 06.04.14 Time: 15:13 To change
 * this template use File | Settings | File Templates.
 */
public class TennisGame {

	private int playerOne = 0;
	private int playerTwo = 0;

	State state = new Initial();

	private String score = "love all";

	public int getPlayerOne() {
		return playerOne;
	}

	public int getPlayerTwo() {
		return playerTwo;
	}

	public void playerOneScores() {
		playerOne++;
		state = state.playerScored(this);
	}

	public void playerTwoScores() {
		playerTwo++;
		state = state.playerScored(this);
	}

	void setScore(String score) {
		this.score = score;
	}

	public String score() {
		return score;
	}

}
