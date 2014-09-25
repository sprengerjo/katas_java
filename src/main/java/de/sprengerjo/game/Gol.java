package de.sprengerjo.game;

import java.util.ArrayList;
import java.util.List;

public class Gol {

	public List<Cell> getNeighbours(int x, int y) {
		List<Cell>result = new ArrayList<Cell>();

		int [] d = new int [] {-1, 0, 1};
		for (int dx : d) {
			for (int dy : d) {
				if(dx == 0 && dy == 0)
					continue;
				result.add(new Cell(x - dx, y - dy));
			}
		}
		return result;
	}

	boolean living(int i, boolean b) {
		if(i == 3 || b && i == 2 || i == 3){
			return true;
		}
		return false;
	}

	public List<Cell> stepper(List<Cell> blinker) {
		return null;
	}
}
