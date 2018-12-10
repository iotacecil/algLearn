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
        if(A.length() != B.length())return false;

        boolean same = false;
        int[] acnt = new int[26];
        int dif = 0;
        int idx1 = -1,idx2=-1;
        for(int i = 0;i<A.length();i++){
            acnt[A.charAt(i) -'a']++;
            if(acnt[A.charAt(i) -'a'] >=2)same = true;
            if(dif == 0 && i == A.length()-1)return same;
            if(A.charAt(i) != B.charAt(i)){

                dif++;

                if(dif>2)return false;
                if(idx1 < 0 )idx1 = i;
                else idx2 = i;
            }
        }
//        System.out.println(idx1+" "+idx2);
        if(idx1!=idx2)return A.charAt(idx1) == B.charAt(idx2) && A.charAt(idx2) ==B.charAt(idx1);
        return false;
    }

    public static void main(String[] args) {
        lc859 sl = new lc859();
        System.out.println(sl.buddyStrings("ab", "ab"));
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
