package leetcode;

import org.apache.commons.lang3.StringUtils;

public class lc65 {
    public boolean isNumber(String s) {
        return s.trim().matches("(-|\\+)?(([0-9]+(e(-|\\+)?[0-9]+)?)|([0-9]*\\.[0-9]+(e?(-|\\+)?[0-9]+)?)|([0-9]+\\.[0-9]*(e?(-|\\+)?[0-9]+)?))$");
    }
    public boolean isNumberUtil(String s){
        return true;
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.isNumericSpace(" 0.1 "));

    }
}
