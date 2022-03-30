package algo.prac.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public final class FizzBuzz {
    // Problem
    // For multiples of 3 store Fizz intestead of the number
    // For multiples of 5 store Buzz instead of the number
    // For number which are multiples of both 3 and 5 store "FizzBuzz"

    // My implementation
    public static List<String> fizzbuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String temp = Integer.toString(i);
            if (i % 3 == 0) {
                temp = "Fizz";
            }
            if (i % 5 == 0) {
                temp = "Buzz";
            }
            if (i % 3 == 0 && i % 5 == 0) {
                temp = "FizzBuzz";
            }
            result.add(temp);
        }
        return result;
    }

    // Better implementation
    public static List<String> fizzBuzzBetter(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fizzbuzz(100));
        System.out.println(fizzBuzzBetter(15));
    }
}
