package de.sprengerjo.game;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BowlingGame {

	List<Integer> scores = new ArrayList<Integer>();

	public void roll(int i) {
		scores.add(i);
	}

	public int score() {
		// no possibility to obtain index 
		AtomicInteger index = new AtomicInteger();
		return scores.stream()
				.map((pins) -> pins + calculateBonus(index))
				.reduce(0, (sum, pins) -> sum + pins);
	}

	private int calculateBonus(AtomicInteger i) {
		int index = i.getAndIncrement();
		if (isNotLastFrame(index)) {
			if (isStrike(index)) {
				return scores.get(index + 1) + scores.get(index + 2);
			} else if (isSpare(index)) {
				i.incrementAndGet();
				return scores.get(index + 2);
			}
		}
		return 0;
	}

	private boolean isStrike(int index) {
		return 10 == scores.get(index);
	}

	private boolean isSpare(int index) {
		return 10 == scores.get(index) + scores.get(index + 1);
	}

	private boolean isNotLastFrame(int index) {
		return index < scores.size() - 3;
	}
}
