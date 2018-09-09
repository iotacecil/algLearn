package dsLearn;

import java.util.Arrays;

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
    //变成拉斯维加斯算法
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
        //一开始就匹配成功
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

//    clean KMP
    public static int serachByKMP(String source,String target){
        if(source.length()<target.length())return -1;
        if(target==null||target.length()==0)return 0;
        int M = target.length();
        int N = source.length();
        //longest proper prefix
        // prefixes of “ABC” are “”, “A”, “AB” and “ABC”.
        //
        // Proper prefixes are “”, “A” and “AB”.
        // Suffixes of the string are “”, “C”, “BC” and “ABC”.

//        lps[i] = the longest proper prefix of pat[0..i]
//        which is also a suffix of pat[0..i]

        //For the pattern “AAACAAAAAC”,
        //lps[] is [0, 1, 2, 0, 1, 2, 3, 3, 3, 4]
        int[] dfa = new int[M];
        int k = 0;
        dfa[0] =0;
        for (int i = 1; i < M; i++) {
            while (k>0&&target.charAt(k)!=target.charAt(i))
                k = dfa[k-1];
            if(target.charAt(k)==target.charAt(i)){
                k++;
            }
            dfa[i]=k;
        }
       System.out.println(Arrays.toString(dfa));

        int q = 0;
        //[0, 0, 0, 1, 0]
        //"mississippi",
        // "issip" q=4 i=5 dfa[3]=1
        // "issip" q=1 i=5
        //    "issip"
        for (int i = 0; i <N ; i++) {
            while(q>0&&target.charAt(q)!=source.charAt(i)){
                System.out.println(q+" "+i);
                System.out.println(target.charAt(q));
                System.out.println(source.charAt(i));

                q = dfa[q-1];
                System.out.println();

            }

            if(target.charAt(q)==source.charAt(i))
                q++;
            if(q==M)
                return i-M+1;
        }
        return -1;

    }


    //KMP DFA
    public static int serachByDfa(String source,String target){
        System.out.println("---DFA---");
        if(source.length()<target.length())return -1;
        if(target==null||target.length()==0)return 0;
//        int R = 256;
        int R = 26;
        int M = target.length();
        int[][] dfa = new int[R][M];

        dfa[target.charAt(0)-'a'][0] =1;
        for(int X = 0,j=1;j<M;j++){
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X];
            }
            dfa[target.charAt(j)-'a'][j] = j+1;

            X = dfa[target.charAt(j)-'a'][X];


        }
        System.out.println(Arrays.deepToString(dfa));

        int i,j,N = source.length();
        for (i = 0,j=0; i  < N&&j< M; i++) {
            j = dfa[source.charAt(i)-'a'][j];
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

}
