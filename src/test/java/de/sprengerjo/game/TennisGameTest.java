package de.sprengerjo.game;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created with IntelliJ IDEA.
 * User: cojo
 * Date: 06.04.14
 * Time: 15:12
 * To change this template use File | Settings | File Templates.
 */
public class TennisGameTest {

    @Test
    public void score0MustBeLove() {
        TennisGame game = new TennisGame();
        assertThat(game.score(0), equalTo("love"));
    }
}
