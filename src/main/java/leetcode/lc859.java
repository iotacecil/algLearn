package leetcode;
//Input: A = "aaaaaaabc", B = "aaaaaaacb"
//Output: true
//

//Input: A = "ab", B = "ba"
//Output: true
//A[0]=B[1] A[1]=B[0]


//swap two letters in A so that the result equals B
public class lc859 {
    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length())return false;
        int[] a = new int[26];
        int[] b = new int[26];
        int diff = 0;
        for(int i =0;i<A.length();i++){
            if(A.charAt(i)!=B.charAt(i)&&diff++>2)return false;
            // System.out.println(i);
            a[A.charAt(i)-'a']++;

            b[B.charAt(i)-'a']++;
        }
        for(int i =0;i<26;i++){
            //为什么是>1
            if(diff ==0&&a[i]>1)return true;
            if(a[i]!=b[i])return false;
        }
        return diff == 2;
    }

    public static void main(String[] args) {
        lc859 sl = new lc859();
        System.out.println(sl.buddyStrings("ab", "ba"));
    }
//    public boolean buddyStrings(String A, String B) {
//        if(A.length() != B.length())return false;
//        if(A.equals(B)){
////            Input: A = "aa", B = "aa"
////            Output: true
//
////            Input: A = "ab", B = "ab"
////            Output: false
//            Set<Character> s = new HashSet<>();
//            for(char c :A.toCharArray()) s.add(c);
//            return s.size()<A.length();
//            int [] count = new int[26];
//            for (int i = 0; i <A.length() ; i++) {
//                count[A.charAt(i)-'a']++;
//
//            }
//            for(int c:count){
//                if(c>0)return true;
//            }
//            return false;
//        }
//    }
}
