package de.sprengerjo.game;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Gol {

	public List<Cell> getNeighbours(Cell cell) {
		List<Cell> result = new ArrayList<Cell>();

		int[] d = new int[] { -1, 0, 1 };
		for (int dx : d) {
			for (int dy : d) {
				if (dx == 0 && dy == 0)
					continue;
				result.add(new Cell(cell.getX() - dx, cell.getY() - dy));
			}
		}
		return result;
	}

	boolean living(long i, boolean b) {
		if (i == 3 || b && i == 2 || i == 3) {
			return true;
		}
		return false;
	}

	public List<Cell> stepper(List<Cell> blinker) {
		Map<Cell, Long> frequecies = blinker.stream()
				.flatMap(a -> getNeighbours(a).stream())
				.collect(groupingBy(c -> c, counting()));

		List<Cell> nextGen = frequecies
				.entrySet()
				.stream()
				.filter(a -> living(a.getValue(), blinker.contains(a.getKey())))
				.map(b -> b.getKey()).collect(toList());

		return nextGen;
	}

}
