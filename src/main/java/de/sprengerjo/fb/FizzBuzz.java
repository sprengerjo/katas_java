package de.sprengerjo.fb;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by sprengerjo on 07.07.17.
 */
public class FizzBuzz {

    public static List<String> upToConditional(int n) {
        return IntStream
                .range(1, n + 1)
                .mapToObj(i -> fizzBuzzConditional(i))
                .collect(Collectors.toList());
    }

    private static String fizzBuzzConditional(int i) {
        if (i % 15 == 0) {
            return "fizzbuzz";
        } else if (i % 3 == 0) {
            return "fizz";
        } else if (i % 5 == 0) {
            return "buzz";
        } else {
            return String.valueOf(i);
        }
    }

    public static List<String> upToLookUp(int n) {
        return IntStream
                .range(1, n + 1)
                .mapToObj(i -> fizzBuzzLookUp(i))
                .collect(Collectors.toList());
    }

    private static String fizzBuzzLookUp(int i) {
        Function<Integer, String> s = j -> String.valueOf(j);
        Function<Integer, String> f = j -> "fizz";
        Function<Integer, String> b = j -> "buzz";
        Function<Integer, String> fb = j -> "fizzbuzz";

        List<Function<Integer, String>> fbs = Arrays.asList(s, s, f, s, b, f, s, s, f, b, s, f, s, s, fb);

        return fbs.get((i - 1) % 15).apply(i);
    }
}
