package courseBook.dsLearn.basic;

import java.util.Arrays;
import java.util.Comparator;

//策略模式
interface Sorter{
    public <T extends Comparable<T>> void sort(T[] list);
    public <T> void sort(T[] list,Comparator<T> comp);
}
public class BubbleSoter implements Sorter{


    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        boolean swapped = true;
        for (int i = 1; i < list.length-1&&swapped; i++) {
            swapped = false;
            for (int j = 1; j <list.length ; j++) {
                if(list[j].compareTo(list[j+1])>0){
                    T tmp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = tmp;
                    swapped =true;
                }

            }

        }
    }

    @Override
    public <T> void sort(T[] list, Comparator<T> comp) {
        boolean swapped = true;
        for (int i = 1; i < list.length&&swapped; i++) {
            swapped = false;
            for (int j = 0; j <list.length-1 ; j++) {
                if(comp.compare(list[j],list[j+1])>0){
                    T tmp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = tmp;
                    swapped =true;
                }

            }

        }
    }

    public static void main(String[] args) {
        BubbleSoter sl = new BubbleSoter();
        //泛型不能用基本类型
        Integer [] ints = {9, 8, 3, 2, 4, 5, 6, 7};

        sl.sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}

