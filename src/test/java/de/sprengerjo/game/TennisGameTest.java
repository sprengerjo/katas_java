package de.sprengerjo.game;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created with IntelliJ IDEA.
 * User: cojo
 * Date: 06.04.14
 * Time: 15:12
 */
public class TennisGameTest {
    TennisGame game = null;
    @Before
    public void setUp() {
        game = new TennisGame();
    }

    @Test
    public void initalScoreMustBeLoveAll() {
        assertThat(game.score(), equalTo("love all"));
    }

    @Test
    public void playerOneScores() {
        game.playerOneScores();
        assertThat(game.score(), equalTo("fifteen love"));
    }

    @Test
    public void playerTwoScores() {
        game.playerTwoScores();
        assertThat(game.score(), equalTo("love fifteen"));
    }

    @Test
    public void deuce() {
        scoreMany(4);
        assertThat(game.score(), equalTo("deuce"));
    }

    @Test
    public void advantangePlaywerOne() {
        scoreMany(4);
        game.playerOneScores();
        assertThat(game.score(), equalTo("advantage player one"));
    }

    @Test
    public void advantangePlaywerTwo() {
        scoreMany(4);
        game.playerTwoScores();
        assertThat(game.score(), equalTo("advantage player two"));
    }

    @Test
    public void winnerPlayerOne() {
        scoreMany(4);
        game.playerOneScores();
        game.playerOneScores();
        assertThat(game.score(), equalTo("winner player one"));
    }

    @Test
    public void winnerPlayerTwo() {
        scoreMany(4);
        game.playerTwoScores();
        game.playerTwoScores();
        assertThat(game.score(), equalTo("winner player two"));
    }

    @Test
    public void sweepWinnerPlayerTwo() {
        game.playerTwoScores();
        game.playerTwoScores();
        game.playerTwoScores();
        game.playerTwoScores();
        assertThat(game.score(), equalTo("winner player two"));
    }

    private void scoreMany(int points) {
        int i = 0;
        while (i++ < points) {
            game.playerOneScores();
            game.playerTwoScores();
        }

    }
}
