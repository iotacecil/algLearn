package leetcode;
/*
好好思考下是否需要计算整个长度，比如 1234321，其实不然，我们只需要计算一半的长度即可，就是在计算过程中的那个逆序数比不断除 10 的数大就结束计算即可，但是这也带来了另一个问题，比如 10 的倍数的数 10010，它也会返回 true，所以我们需要对 10 的倍数的数再加个判断即可，代码如下所示。
 */
/*
if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int halfReverseX = 0;
        while (x > halfReverseX) {
            halfReverseX = halfReverseX * 10 + x % 10;
            x /= 10;
        }
        return halfReverseX == x || halfReverseX / 10 == x;
 */
public class Palindrome {
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        long in = x;
        long out = 0;

        for(;x!=0;x/=10){
            out = out*10 + x%10;
        }
        return out == in;
    }

}
