package de.sprengerjo.game;

/**
 * Created with IntelliJ IDEA.
 * User: cojo
 * Date: 06.04.14
 * Time: 15:13
 * To change this template use File | Settings | File Templates.
 */
public class TennisGame {

    private int playerOne = 0;
    private int playerTwo = 0;

    State state = new State();

    public void playerOneScores() {
        playerOne++;
    }

    public void playerTwoScores() {
        playerTwo++;
    }


    String score(int i) {
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

    public String score() {
        String score = "love all";
        if (state.isWinner()) {
            score = "winner " + obtainLeadingPayer();
        } else if (state.isAdvantage()) {
            score = "advantage " + obtainLeadingPayer();
        } else if (state.isDeuce()) {
            score = "deuce";
        } else if (playerOne > 0 || playerTwo > 0) {
            score = score(playerOne) + " " + score(playerTwo);
        }
        return score;
    }


    private String obtainLeadingPayer() {
        String result = "player ";
        if (playerOne > playerTwo) {
            result += "one";
        } else {
            result += "two";
        }
        return result;
    }

    private class State {
        private boolean isDeuce() {
            return playerOne == playerTwo && playerOne >= 3;
        }

        private boolean isAdvantage() {
            return playerOne != playerTwo && playerOne + playerTwo > 5;
        }

        private boolean isWinner() {
            return Math.abs(playerOne - playerTwo) > 1 && playerOne + playerTwo > 3;
        }
    }

}
