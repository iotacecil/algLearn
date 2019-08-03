package niuke.wangyi;

import ConcurBook.NotSafe;

import java.lang.annotation.*;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@interface MyAnnotation {
    String value() default "";

    int num() default 100;

    String[] address() default {};
}


@Target(ElementType.TYPE)
@interface aaa {


}

@aaa
@MyAnnotation
class aa {

}

@aaa
@MyAnnotation
@NotSafe
public class 矩形重叠2019 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Class<矩形重叠2019> cls = 矩形重叠2019.class;
//        System.out.println(Arrays.toString(aa.class.getAnnotations()));
//        System.out.println(Arrays.toString(cls.getAnnotations()));
        int n = sc.nextInt();
//        String[] split = sc.next().split(" ");
        long[] x1 = new long[n];

        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextLong();
        }

        long[] y1 = new long[n];
        for (int i = 0; i < n; i++) {
            y1[i] = sc.nextLong();
        }
        long[] x2 = new long[n];
        for (int i = 0; i < n; i++) {
            x2[i] = sc.nextLong();
        }
        long[] y2 = new long[n];
        for (int i = 0; i < n; i++) {
            y2[i] = sc.nextLong();
        }
        long[] allx = new long[2 * n];
        for (int i = 0; i < n; i++) {
            allx[i] = x1[i];
            allx[n + i] = x2[i];

        }
        long[] ally = new long[2 * n];
        for (int i = 0; i < n; i++) {
            ally[i] = y1[i];

            ally[n + i] = y2[i];

        }

        int max = 0;
        for (long x : allx) {
            for (long y : ally) {
                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    if (x >= x1[i] && y >= y1[i] && x <= x2[i] && y <= y2[i]) cnt++;
                }
                max = Math.max(cnt, max);

            }


        }
        System.out.println(max);


    }
}
