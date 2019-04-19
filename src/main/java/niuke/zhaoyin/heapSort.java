package niuke.zhaoyin;



public class heapSort {
    static class ex{
        public static void greet(){
            System.out.println("Aa");
        }
    }
    public static void main(String[] args) {
        ex x = null;
//       ex aa = new ex();
        ((ex)null).greet();
//        DateFormat df;
//        Date date = new Date();
//        df = DateFormat.getInstance();

//        String str = "aa".to
//        int[] arr = {1,2,3,4,5,6};
//
//        int n = 6;
//        heapify(arr);
//        System.out.println(Arrays.toString(arr));
//        for (int i = 0; i <arr.length ; i++) {
//            swap(arr,0,n-1-i);
//            System.out.println("top:"+arr[0]);
//            System.out.println(Arrays.toString(arr));
//            shiftDown(arr,0,n-1-i);
//            System.out.println(Arrays.toString(arr));
//        }
//        for(int i = 0;i<arr.length;i++){
//            System.out.print(arr[i]);
//            if(i!=arr.length-1){
//                System.out.print(" ");
//            }
//        }
    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    //大顶堆
    private static void shiftDown(int[] arr,int idx,int n){
        int lowest = n/2;
        while(idx < lowest){
            int left = (idx*2) + 1;
            int right = left + 1;
            if(right < n && arr[left]<arr[right] && arr[right]>arr[idx]){
                swap(arr,idx,right);
                idx = right;
            }else if(arr[idx] < arr[left]){
                swap(arr,idx,left);
                idx = left;
            }else break;
        }
    }

    private static void heapify(int[]arr){
        int n = arr.length;
        for(int i = (n-1)/2;i>=0;i--){
            shiftDown(arr,i,n);
        }
    }
}
