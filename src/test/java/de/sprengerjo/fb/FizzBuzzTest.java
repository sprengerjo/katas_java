package de.sprengerjo.fb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

/**
 * Created by sprengerjo on 07.07.17.
 */
public class FizzBuzzTest {

    List<Function<Integer, List<String>>> fbs;
    int N = 10000000;
    int TIMEOUT = 3;
    String MESSAGE = String.format("The doPayment method take more than %s seconds", TIMEOUT);

    @BeforeEach
    void setUp() {
        fbs = Arrays.asList(
                i -> FizzBuzz.upToConditional(i),
                i -> FizzBuzz.upToLookUp(i));
    }

    @Test
    void upTo1() {
        fbs.forEach(fun -> {
            List<String> actual = fun.apply(1);
            List<String> expected = Arrays.asList("1");

            assertEquals(expected, actual);
        });
    }

    @Test
    void upTo2() {
        fbs.forEach(fun -> {
            List<String> actual = fun.apply(2);
            List<String> expected = Arrays.asList("1", "2");

            assertEquals(expected, actual);
        });
    }

    @Test
    void upToFizz() {
        fbs.forEach(fun -> {
            List<String> actual = fun.apply(3);
            List<String> expected = Arrays.asList("1", "2", "fizz");

            assertEquals(expected, actual);
        });
    }

    @Test
    void upToBuzz() {
        fbs.forEach(fun -> {
            List<String> actual = fun.apply(5);
            List<String> expected = Arrays.asList("1", "2", "fizz", "4", "buzz");

            assertEquals(expected, actual);
        });
    }

    @Test
    void upToFizzBuzz() {
        fbs.forEach(fun -> {
            List<String> actual = fun.apply(15);
            List<String> expected = Arrays.asList("1", "2", "fizz", "4", "buzz",
                    "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "13", "14", "fizzbuzz");

            assertEquals(expected, actual);
        });
    }

    @Test
    void upToNConditional() {
        assertTimeout(ofSeconds(TIMEOUT), () -> {
            FizzBuzz.upToConditional(N);
        }, MESSAGE);
    }

    @Test
    void upToNLookUp() {
        assertTimeout(ofSeconds(TIMEOUT), () -> {
            FizzBuzz.upToLookUp(N);
        }, MESSAGE);
    }

}
