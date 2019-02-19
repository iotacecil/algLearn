package leetcode;

public class lc4 {
    public double findMedianSortedArraysBSright(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return findMedianSortedArraysBSright(nums2, nums1);

        int lo = 0, hi = n1;
        while (lo <= hi){
            // mid:短的那个
            int partX = (lo + hi)/2;
            int partY = (n1+n2+1)/2 - partX;
            //L1<R2 && L2 < R1
            /*
            x1 x2 |  x3 x4 x5 x6
            y1 y2 y3 y4 y5 |  y6 y7 y8

            x2（L1) <= y6(R2) && y5(L2)<= x3(R1)
             */
            double L1 = (partX == 0)?Integer.MIN_VALUE:nums1[partX-1];
            double L2 = (partY == 0)?Integer.MIN_VALUE:nums2[partY-1];
            double R1 = (partX == n1)?Integer.MAX_VALUE:nums1[partX];
            double R2 = (partY == n2)?Integer.MAX_VALUE:nums2[partY];

            if(L1 <= R2 && L2 <= R1){
                if((n1+n2) % 2 ==0){
                    return (Math.max(L1,L2) + Math.min(R1, R2))/2.0;
                }
                else return Math.max(L1, L2);
            }else if(L1 > R2){
                hi = partX - 1;
            }else {
                lo = partX + 1;
            }
        }
        return -1;
    }
        public double findMedianSortedArraysBS(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int l = (n1+n2+1)/2;
        int r = (n1+n2+2)/2;
        return (getkth(nums1, 0, nums2,0 ,l )+getkth(nums1, 0, nums2,0 ,l ))/2;

    }
    public double getkth(int[] A,int idx1,int[]B,int idx2,int k){
        if(idx1 > A.length - 1)return B[idx2+k-1];
        if(idx2 > B.length - 1)return B[idx1+k-1];
        if(k==1)return Math.min(A[idx1],B[idx2]);
        int amid = Integer.MAX_VALUE,bmid = Integer.MAX_VALUE;
        if(idx1+k/2-1<A.length) amid = A[idx1+k/2-1];
        if(idx2+k/2-1<B.length) bmid = B[idx1+k/2-1];
        if(amid < bmid)return getkth(A, idx1+k/2, B, idx2, k-k/2);
        else return getkth(A, idx1, B,idx2+k/2,k-k/2 );
    }
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int midl = (n1+n2-1)/2;
        if(n1 ==0){
            if((n1+n2)%2==0){
                return (nums2[midl]+nums2[midl+1])/2.0;
            }else return nums2[midl];
        }

      if(n2 ==0){
          if((n1+n2)%2==0){
              return (nums1[midl]+nums1[midl+1])/2.0;
          }else return nums1[midl];
      }
        int cnt = 0;
        int idx1 = 0;
        int idx2 = 0;
        int med = -1;

        while(cnt <= midl){

            if(idx1 < n1 && idx2 <n2){

            int top1 = nums1[idx1];
            int top2 = nums2[idx2];

            if(top1 <= top2){
                idx1++;
                med = top1;
            }else{
                idx2++;
                med = top2;
            }
            }
            else if(idx2 < n2){
                med = nums2[idx2];
                idx2++;
            }
            else if(idx1 < n1){
                med = nums1[idx1];
                idx1++;

            }


            if(cnt == midl && (n1+n2) % 2 == 1){
                return med;
            }else if(cnt == midl && (n1+n2)% 2 != 1){
                int next = 0;
                if(idx1<n1 && idx2 <n2)
                next= nums1[idx1]>nums2[idx2]? nums2[idx2]:nums1[idx1];
                else if(idx1 == n1)next = nums2[idx2];
                else if(idx2 == n2)next = nums1[idx1];

                return (next + med)/2.0;
            }
            cnt++;
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] num1 = {1};
        int[] num2 ={3,4,5,6,7,8,9,10};
        System.out.println(new lc4().findMedianSortedArraysBSright(num1, num2));
    }
}
