package dsLearn;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class substringbacku {

    //RabinKarp
//    private long longRandomPrime(){
//        BigInteger prime = BigInteger.probablePrime(31,new Random());
//        return prime.longValue();
//    }
    int R = 256;
    long q;

    private long hash(String key, int m) {
        long h = 0;
        for (int j = 0; j < m; j++)
            h = (R * h + key.charAt(j)) % q;
        return h;
    }
    private boolean check(String source,String target, int i) {
        for (int j = 0; j <target.length() ; j++)
            if (target.charAt(j) != source.charAt(i + j))
                return false;
        return true;
    }
    public  int searchRabinKarp(String source,String target){
        if(source.length()<target.length())return -1;
        if(target==null||target.length()==0)return 0;
        int R = 256;
        int m = target.length();
        int n = source.length();
        long RM = 1;
        q = 1877124611;
        System.out.println(q);
        for (int i = 1; i <=m-1 ; i++) {
            RM = (R * RM) % q;
        }
        long patHash = hash(target,m);
        long txtHash = hash(source, m);
        System.out.println(patHash);
        System.out.println(txtHash);

        if ((patHash == txtHash) && check(source,target, 0))
            return 0;

        // check for hash match; if hash match, check for exact match
        for (int i = m; i < n; i++) {
            // Remove leading digit, add trailing digit, check for match.
            txtHash = (txtHash + q - RM*source.charAt(i-m) % q) % q;
            txtHash = (txtHash*R + source.charAt(i)) % q;

            // match
            int offset = i - m + 1;
            if ((patHash == txtHash) && check(source, target,offset))
                return offset;
        }

        // no match
        return -1;

    }


    //boyer-Moore
    public static int searchBoyer(String source,String target){
        if(source.length()<target.length())return -1;
        if(target==null||target.length()==0)return 0;
        int R = 26;
        int[] right = new int[R];
        for (int c = 0; c < R; c++)
        right[c] = -1;
        for (int j = 0; j < target.length(); j++){
            right[target.charAt(j)-'a'] = j;

            System.out.println(target.charAt(j) - 'a');
        }
        int m = target.length();
        int n = source.length();
        int skip;
        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            for (int j = m-1; j >= 0; j--) {
                if (target.charAt(j) != source.charAt(i+j)) {
                    skip = Math.max(1, j - right[source.charAt(i+j)-'a']);
                    break;
                }
            }
            if (skip == 0) return i;
        }
        return -1;
    }


    //KMP DFA
    //todo 可以去掉R
    public static int serachByDfa(String source,String target){
        if(source.length()<target.length())return -1;
        if(target==null||target.length()==0)return 0;
        int R = 256;
        int M = target.length();
        int[][] dfa = new int[R][M];

        dfa[target.charAt(0)][0] =1;
        for(int X = 0,j=1;j<M;j++){
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][X];
            dfa[target.charAt(j)][j] = j+1;
            X = dfa[target.charAt(j)][X];

        }

        int i,j,N = source.length();
        for (i = 0,j=0; i  < N&&j< M; i++) {
            j = dfa[source.charAt(i)][j];
        }
        if(j==M) return i-M;
        else return -1;


    }




    private static int search(String source,String target){
        if(source.length()<target.length())return -1;
        if(source==null||source.length()==0)return 0;
        int i,N = source.length();
        int j,M = target.length();
        for (i = 0,j=0; i <N&&j<M ; i++) {
            if(source.charAt(i)==target.charAt(j))j++;
            else{
                i-=j;
                j=0;
            }
        }
        if(j==M)return i-M;
        else return -1;
    }
    static int indexOf(char[] source, int sourceOffset, int sourceCount,
                       char[] target, int targetOffset, int targetCount,
                       int fromIndex) {
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }

        char first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);

                if (j == end) {
                    /* Found whole string. */
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }
    //ABA B
    static int indexOf(String source,String target){
        if(source.length()<target.length())return -1;
        if(target==null||target.length()==0)return 0;
        int lens = source.length();
        int tar = target.length();
        char[] targetArr = target.toCharArray();
        char[] sourceArr = source.toCharArray();
        char first = targetArr[0];
        int max = lens-tar;
        for (int i = 0; i <= max ; i++) {
            if(sourceArr[i]!=first){
                while (++i<=max&&sourceArr[i]!=first);
            }
            if(i<=max){
                int j = i+1;
                int end = j+tar-1;
                for (int k = 1; j <end&&sourceArr[j]==targetArr[k] ; k++,j++) ;
                if(j == end)return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        substringbacku sl = new substringbacku();
        System.out.println(sl.searchRabinKarp("hello", "ll"));
//        int a = 2;
//        System.out.println(Integer.toBinaryString(a));
//        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//        StringBuilder sb1 =new StringBuilder();
//        StringBuilder sb2 =new StringBuilder();
//        Random random=new Random(1024);
//        String[] sources = new String[50];
//        String[] targets = new String[50];
//        System.out.println("boyer"+searchBoyer("hello", "ll"));
//
//        for (int k = 0; k <sources.length ; k++) {
//
//
//            int length = random.nextInt(1000);
//            for (int i = 0; i < length; i++) {
//                int number = random.nextInt(62);
//                sb1.append(str.charAt(number));
//                if (i >= length*3/5&&i <= length*4/5)
//                    sb2.append(str.charAt(number));
//            }
//            sources[k] = sb1.toString();
//            targets[k] = sb2.toString();
//        }
////        System.out.println(Arrays.toString(targets));
////        System.out.println(sources[0].length());
////        System.out.println(targets[0].length());
//        long start = System.currentTimeMillis();
//        for(int i=0;i<sources.length;i++){
////            serachByDfa(sources[i],targets[i]);
//            searchBoyer(sources[i],targets[i]);
////            indexOf(sources[i],targets[i]);
//        }
//
//        long end = System.currentTimeMillis();
//        System.out.println("用时"+(end-start));
//
//        System.out.println(search("ADAC", "ABACADABRAC"));
//
//        String source = "hello";
//        String target = "ll";
//        System.out.println("DFA"+serachByDfa("aaaaa", "aaa"));
//
//        System.out.println(search( source,target));
//        System.out.println();
//
//        System.out.println(indexOf( source.toCharArray(),0,source.length(),target.toCharArray(),0,target.length(),0));
    }
}
