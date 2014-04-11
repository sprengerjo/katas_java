package de.sprengerjo.game;

abstract class State {

	State playerScored(TennisGame game) {
		State current = switchState(game);
		game.setScore(current.score(game));
		return current;
	}

	protected abstract State switchState(TennisGame game);

	protected abstract String score(TennisGame game);

	protected String score(int i) {
		switch (i) {
		case 0:
			return "love";
		case 1:
			return "fifteen";
		case 2:
			return "thirty";
		case 3:
			return "fourty";
		}
		return null;
	}

	protected String obtainLeadingPayer(TennisGame game) {
		int playerOne = game.getPlayerOne();
		int playerTwo = game.getPlayerTwo();
		String result = "player ";
		if (playerOne > playerTwo) {
			result += "one";
		} else {
			result += "two";
		}
		return result;
	}

}

class Initial extends State {

	protected State switchState(TennisGame game) {
		int playerOne = game.getPlayerOne();
		int playerTwo = game.getPlayerTwo();

		if (Math.abs(playerOne - playerTwo) > 1 && playerOne + playerTwo > 3) {
			return new Winner();
		} else if (playerOne == playerTwo && playerOne + playerTwo > 3) {
			return new Deuce();
		} else {
			return this;
		}
	}

	public String score(TennisGame game) {
		int playerOne = game.getPlayerOne();
		int playerTwo = game.getPlayerTwo();

		String score = "love all";
		if (playerOne > 0 || playerTwo > 0) {
			score = score(playerOne) + " " + score(playerTwo);
		}
		return score;
	}
}

class Deuce extends State {

	@Override
	protected
	State switchState(TennisGame game) {
		return new Advantange();
	}

	@Override
	protected
	String score(TennisGame game) {
		return "deuce";
	}
}

class Advantange extends State {

	@Override
	protected
	State switchState(TennisGame game) {
		int playerOne = game.getPlayerOne();
		int playerTwo = game.getPlayerTwo();

		if (Math.abs(playerOne - playerTwo) > 1 && playerOne + playerTwo > 3) {
			return new Winner();
		} else {
			return new Deuce();
		}
	}

	@Override
	protected
	String score(TennisGame game) {
		return "advantage " + obtainLeadingPayer(game);
	}
}

class Winner extends State {

	@Override
	protected
	State switchState(TennisGame game) {
		return this;
	}

	@Override
	protected
	String score(TennisGame game) {
		return "winner " + obtainLeadingPayer(game);
	}
}
