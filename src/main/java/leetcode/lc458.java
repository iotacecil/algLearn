package leetcode;

public class lc458 {
    //log2 1000  = log
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int)Math.ceil(Math.log(buckets)/Math.log(minutesToTest / minutesToDie + 1));
    }
}
