package javaMistory;

public class LongDivision {
    public static void main(String[] args) {
        final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
        final long MICROS_PER_DAY3 = 24l * 60 * 60 * 1000 * 1000;
        final long MICROS_PER_DAY2 = 86400000000l;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
        System.out.println(MICROS_PER_DAY3 / MILLIS_PER_DAY);
        System.out.println(MICROS_PER_DAY2 / MILLIS_PER_DAY);

    }
}
