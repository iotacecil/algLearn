package dsLearn.basic;

public class getMax {
    public static int getMa(int[] arr,int L,int R){
        if(L== R)return arr[L];
        int mid = (L+R)/2;
        int maxLeft = getMa(arr,0,mid);
        int maxright = getMa(arr,mid+1,R);
        return Math.max(maxLeft,maxright);

    }

    public static void main(String[] args) {
        int[] ints = {9, 5, 4, 7, 2, 3, 5, 8, 2};
        System.out.println(getMa(ints, 0, ints.length-1));
    }
}
