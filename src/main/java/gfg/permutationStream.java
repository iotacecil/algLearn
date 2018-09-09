package gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class permutationStream {


        public static <T> Stream<Stream<T>> of(final List<T> items) {
            return IntStream.range(0, factorial(items.size())).mapToObj(i -> permutation(i, items).stream());
        }

        private static int factorial(final int num) {
            return IntStream.rangeClosed(2, num).reduce(1, (x, y) -> x * y);
        }

        private static <T> List<T> permutation(final int count, final LinkedList<T> input, final List<T> output) {
            if (input.isEmpty()) { return output; }

            final int factorial = factorial(input.size() - 1);
            output.add(input.remove(count / factorial));
            return permutation(count % factorial, input, output);
        }

        private static <T> List<T> permutation(final int count, final List<T> items) {
            return permutation(count, new LinkedList<>(items), new ArrayList<>());
        }

    public static void main(String[] args) {
            int[] num = new int[29];
        for (int i = 0; i <29 ; i++) {
            num[i] = i;

        }

        permutationStream.of(Arrays.asList(num)).forEach(p -> { p.forEach(System.out::print); System.out.print(" "); });
    }

    }

