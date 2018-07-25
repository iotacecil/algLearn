package gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
有编号1-100的帽子，每个人有收集的帽子，求每个人选一个帽子不一样的种数
 */
// Java program to find number of ways to wear hats

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;


public class bitmaskCap {
    static final int MOD = 1000000007;

    // for input
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // capList[i]'th vector contains the list of persons having a cap with id i
    // id is between 1 to 100 so we declared an array of 101 vectors as indexing
    // starts from 0.
    static Vector<Integer> capList[] = new Vector[4];


    // dp[2^10][101] .. in dp[i][j], i denotes the mask i.e., it tells that
    // how many and which persons are wearing cap. j denotes the first j caps
    // used. So, dp[i][j] tells the number ways we assign j caps to mask i
    // such that none of them wears the same cap
    static int dp[][] = new int[4][4];

    // This is used for base case, it has all the N bits set
    // so, it tells whether all N persons are wearing a cap.
    static int allmask;

    // mask是戴上帽子的人的掩码，i是第i顶帽子
    // number of caps processed starting from first cap).
    static long countWaysUtil(int mask, int i)
    {
        // 所有人都戴好了帽子就一种
        if (mask == allmask) return 1;
        System.out.println(mask);
        System.out.println(i);

        // If not everyone is wearing a cap and also there are no more
        // caps left to process, so there is no way, thus return 0;
        if (i > 3) return 0;

        // If we already have solved this subproblem, return the answer.
        if (dp[mask][i] != -1) return dp[mask][i];

        // 这群人不戴i这顶帽子
        long ways = countWaysUtil(mask, i+1);

        // 有多少人有i这顶帽子
        int size = capList[i].size();

        //遍历尝试给这j个人戴帽子看看会不会冲突
        for (int j = 0; j < size; j++)
        {
            // 如果j这个人已经戴过帽子了
            if ((mask & (1 << capList[i].get(j))) != 0) continue;

                // 不然给这个人戴帽子并且把这个人加到掩码里 下一个
            else ways += countWaysUtil(mask | (1 << capList[i].get(j)), i+1);
            ways %= MOD;
        }

        // 如果这顶帽子和现在mask的人都冲突 结果是之前不戴这个帽子的ways
        return dp[mask][i] = (int) ways;
    }

    // Reads n lines from standard input for current test case
    static void countWays(int n) throws Exception
    {
        //----------- READ INPUT --------------------------
        String str;
        String split[];
        int x;

        for (int i=0; i<n; i++)
        {
            str = br.readLine();
            split = str.split(" ");

            // while there are words in the split[]
            for (int j = 0; j < split.length; j++) {
                // add the ith person in the list of cap if with id x
                x = Integer.parseInt(split[j]);
                capList[x].add(i);
            }

        }
        for(Vector a :capList){
            System.out.println(a);
        }
        //----------------------------------------------------

        // All mask is used to check of all persons
        // are included or not, set all n bits as 1
        allmask = (1 << n) - 1;

        // Initialize all entries in dp as -1
        for (int[] is : dp) {
            for (int i = 0; i < is.length; i++) {
                is[i] = -1;
            }
        }

        // Call recursive function count ways
        System.out.println(countWaysUtil(0, 1));
    }

    // Driver method
    public static void main(String args[]) throws Exception
    {
        int n;   // number of persons in every test case

        // initializing vector array
        for (int i = 0; i < capList.length; i++)
            capList[i] = new Vector<>();


        n = Integer.parseInt(br.readLine());
        countWays(n);
    }


    }





//



