package de.sprengerjo.game;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
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
				hasItems(new Cell(0, 0), new Cell(0, 1), new Cell(0, 2),
						new Cell(1, 0), new Cell(1, 2), new Cell(2, 0),
						new Cell(2, 1), new Cell(2, 2)));
	}

	@Test
	public void stepperForBlinker() throws Exception {
		List<Cell> blinker = new ArrayList<Cell>();
		blinker.add(new Cell(1, 0));
		blinker.add(new Cell(1, 1));
		blinker.add(new Cell(1, 2));
		
		assertThat(gol.stepper(blinker),
				hasItems(new Cell(2, 1), new Cell(0, 1)));
	}

	@Test
	public void deadCellWithoutNeighboursMustDie() throws Exception {
		assertThat(gol.living(0, false), is(false));
	}

	@Test
	public void deadCellWit1NeighboursMustDie() throws Exception {
		assertThat(gol.living(1, false), is(false));
	}

	@Test
	public void deadCellWit2NeighboursMustDie() throws Exception {
		assertThat(gol.living(2, false), is(false));
	}

	@Test
	public void deadCellWit3NeighboursMustNotDie() throws Exception {
		assertThat(gol.living(3, false), is(true));
	}

	@Test
	public void deadCellWit4NeighboursMustNotDie() throws Exception {
		assertThat(gol.living(4, false), is(false));
	}

	@Test
	public void livingCellWit1NeighboursMustDie() throws Exception {
		assertThat(gol.living(1, true), is(false));
	}

	@Test
	public void livingCellWit2NeighboursMustDie() throws Exception {
		assertThat(gol.living(2, true), is(true));
	}

	@Test
	public void livingCellWit3NeighboursMustDie() throws Exception {
		assertThat(gol.living(3, true), is(true));
	}

	@Test
	public void livingCellWit4NeighboursMustDie() throws Exception {
		assertThat(gol.living(4, true), is(false));
	}

}
