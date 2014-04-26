package de.sprengerjo.game;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BowlingGameTest {

	BowlingGame game = null;

	@Before
	public void setUp() {
		game = new BowlingGame();
	}

	private void rollMany(int rolls, int pins) {
		for (int i = 0; i < rolls; i++) {
			game.roll(pins);
		}
	}

	@Test
	public void gutterGameMustScore0() {
		rollMany(20, 0);
		assertThat(game.score(), equalTo(0));
	}

	@Test
	public void onePinGamesMustScore20() {
		rollMany(20, 1);
		assertThat(game.score(), equalTo(20));
	}

	@Test
	public void spareBonusMustBeAdded() {
		game.roll(4);
		game.roll(6);
		rollMany(18, 4);
		assertThat(game.score(), equalTo(4 + 6 + 4 + 18 * 4));
	}

	@Test
	public void strikeBonusMustBeAdded() {
		game.roll(10);
		rollMany(18, 4);
		assertThat(game.score(), equalTo(10 + 4 + 4 + 18 * 4));
	}

	@Test
	public void perfectGame() {
		rollMany(12, 10);
		assertThat(game.score(), equalTo(300));
	}

}
