import java.util.*;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class permu2 {

        public static long factorial(int n) {
//            if (n > 20 || n < 0) throw new IllegalArgumentException(n + " is out of range");
            return LongStream.rangeClosed(2, n).reduce(1, (a, b) -> a * b);
        }
        public static <T> List<T> permutation(long no, List<T> items) {
            return permutationHelper(no,
                    new LinkedList<>(Objects.requireNonNull(items)),
                    new ArrayList<>());
        }
    private static <T> void printThreadInfo(Stream<T> s) {
        System.out.println(Thread.currentThread().getName() + " handles " + s.collect(toList()));
    }
        private static <T> List<T> permutationHelper(long no, LinkedList<T> in, List<T> out) {
            if (in.isEmpty()) return out;
            long subFactorial = factorial(in.size() - 1);
            out.add(in.remove((int) (no / subFactorial)));
            return permutationHelper((int) (no % subFactorial), in, out);
        }
//        @SafeVarargs
        @SuppressWarnings("varargs") // Creating a List from an array is safe
        public static <T> Stream<Stream<T>> of(List<T> items) {
            List<T> itemList = items;
            return LongStream.range(0, factorial(items.size()-1))
                    .mapToObj(no -> permutation(no, items).stream());
        }


    public static void main(String[] args) {
        List<Integer> items = new ArrayList<>();
        for (int i = 0; i <15 ; i++) {
            items.add(i);

        }

        long permutations = permu2.factorial(items.size());

        List<List<Integer>> collect = permu2.of(items)
                .map(s -> s.collect(toList()))
                .collect(toList());
        System.out.println(collect);
    }

}
