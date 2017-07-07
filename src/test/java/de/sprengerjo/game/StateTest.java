package de.sprengerjo.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class StateTest {

    State state = null;

    @BeforeEach
    public void setUp() {
        state = new Initial();
    }

    @Test
    public void score0MustBeLove() {
        assertThat(state.score(0), equalTo("love"));
    }

    @Test
    public void score1MustBeFifteen() {
        assertThat(state.score(1), equalTo("fifteen"));
    }

    @Test
    public void score2MustBeThirty() {
        assertThat(state.score(2), equalTo("thirty"));
    }

    @Test
    public void score3MustBeFourty() {
        assertThat(state.score(3), equalTo("fourty"));
    }
}
