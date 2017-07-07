package de.sprengerjo.game;

import static java.util.stream.IntStream.concat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PrimitiveIterator.OfInt;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BowlingGame {

	private int [] score = new int[21];
	private int current;

	public void roll(int i) {
		score[current++] = i;
	}

	public int score() {
		AtomicInteger index = new AtomicInteger();
		return Arrays.stream(score).map(a -> a + bonus(index)).sum();
	}

	private int bonus(AtomicInteger index) {
		int i = index.getAndIncrement();

		if ( i < current - 3) {
			if (10 == score[i]) {
				return score[i + 1] + score[i + 2];
			} else if (10 == score[i] + score[i + 1]) {
				index.getAndIncrement();
				return score[i + 2];
			}
		}
		return 0;
	}


}
