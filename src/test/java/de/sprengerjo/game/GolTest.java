package de.sprengerjo.game;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GolTest {

	Gol gol;

	@Before
	public void setUp() throws Exception {
		gol = new Gol();
	}

	@Test
	public void neighbours() {
		List<Cell> neighbours = gol.getNeighbours(1, 1);

		assertThat(
				neighbours,
				containsInAnyOrder(new Cell(0, 0), new Cell(0, 1), new Cell(0,
						2), new Cell(1, 0), new Cell(1, 2), new Cell(2, 0),
						new Cell(2, 1), new Cell(2, 2)));
	}

	@Test
	public void stepperForBlinker() throws Exception {
		List<Cell> blinker = new ArrayList<Cell>();
		blinker.add(new Cell(1, 0));
		blinker.add(new Cell(1, 1));
		blinker.add(new Cell(1, 2));

		assertThat(gol.stepper(blinker),
				contains(new Cell(2, 1), new Cell(1, 1), new Cell(0, 1)));
	}

	@Test
	public void deadCellWithoutNeighboursMustDie() throws Exception {
		assertThat(gol.living(0, false), equalTo(false));
	}

	@Test
	public void deadCellWit1NeighboursMustDie() throws Exception {
		assertThat(gol.living(1, false), equalTo(false));
	}

	@Test
	public void deadCellWit2NeighboursMustDie() throws Exception {
		assertThat(gol.living(2, false), equalTo(false));
	}

	@Test
	public void deadCellWit3NeighboursMustNotDie() throws Exception {
		assertThat(gol.living(3, false), equalTo(true));
	}

	@Test
	public void deadCellWit4NeighboursMustNotDie() throws Exception {
		assertThat(gol.living(4, false), equalTo(false));
	}

	@Test
	public void livingCellWit1NeighboursMustDie() throws Exception {
		assertThat(gol.living(1, true), equalTo(false));
	}

	@Test
	public void livingCellWit2NeighboursMustDie() throws Exception {
		assertThat(gol.living(2, true), equalTo(true));
	}

	@Test
	public void livingCellWit3NeighboursMustDie() throws Exception {
		assertThat(gol.living(3, true), equalTo(true));
	}

	@Test
	public void livingCellWit4NeighboursMustDie() throws Exception {
		assertThat(gol.living(4, true), equalTo(false));
	}

}
