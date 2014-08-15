package de.sprengerjo.game;

import static java.util.stream.IntStream.range;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BowlingGameTest {

	BowlingGame g;

	@Before
	public void setUp() throws Exception {
		g = new BowlingGame();
	}

	@Test
	public void gutterGame() throws Exception {
		range(0, 20).forEach(a -> g.roll(0));
		assertThat(g.score(), equalTo(0));
	}

	@Test
	public void onePinGames() throws Exception {
		range(0, 20).forEach(a -> g.roll(1));
		assertThat(g.score(), equalTo(20));
	}

	@Test
	public void spareBonusMustBeAdded() throws Exception {
		g.roll(4);
		g.roll(6);
		range(2, 20).forEach(a -> g.roll(4));
		assertThat(g.score(), equalTo(4 + 6 + 4 + 18 * 4));
	}

	@Test
	public void strikeBonusMustBeAdded() throws Exception {
		g.roll(10);
		range(2, 20).forEach(a -> g.roll(4));
		assertThat(g.score(), equalTo(10 + 4 + 4 + 18 * 4));
	}

	@Test
	public void perfectGame() throws Exception {
		range(0, 12).forEach(a -> g.roll(10));
		assertThat(g.score(), equalTo(300));
	}
}
