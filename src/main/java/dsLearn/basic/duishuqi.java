package dsLearn.basic;

import java.util.Arrays;

public class duishuqi {
    //1. 对数器 产生一个随机size以内长度-value ~ value的数组
    public static int[] generateRandomArray(int size, int value) {
        //产生的数组长度是[0, size]
        int[] arr = new int[(int) ((size + 1) * Math.random())];

        //产生的数组中的数的范围是-value ~ value
        for(int i = 0;i < arr.length;i++) {
            arr[i] = (int) ((value + 1) * Math.random()
                    - (int) (value * Math.random()));
        }
        return arr;
    }
    //2. 写一个绝对正确但是效率不高的答案
    public static void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }
    //判断两个数组是否相等
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
            return false;
        if(arr1 == null && arr2 == null)
            return true;
        if(arr1.length != arr2.length)
            return false;
        for(int i = 0;i < arr1.length;i++) {
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
    //3. 大样本测试
    public static void main(String[] args) {
        //testTime是测试次数
        int testTime = 500000;
        int size = 10;
        int value = 100;
        boolean succeed = true;
        bubbleSort bs = new bubbleSort();
        insertSort is = new insertSort();
        SelectSort ss = new SelectSort();

        for(int i = 0;i < testTime;i++) {
            int[] arr1 = generateRandomArray(size, value);
            //拷贝数组，数组new出来的就是在栈中不同的空间中存放，内容相同
            //copyArray(int[] arr)是自己实现的拷贝方法
            int[] arr2 = arr1.clone();
            int[] arr3 = arr1.clone();
            bs.bubble(arr1);
            rightMethod(arr2);
            if(!isEqual(arr1, arr2)) {
                succeed = false;
                //打印出错的数组，printArray是自习实现的打印的方法
                System.out.println(Arrays.toString(arr3));
                break;
            }
        }
        //打印要测的部分是否正确
        System.out.println(succeed ? "succeed!" : "false..");
    }

}
