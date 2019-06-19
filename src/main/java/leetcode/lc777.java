package leetcode;

public class lc777 {
    public boolean canTransform(String start, String end) {
        int i = 0;
        int j = 1;
        int n = start.length();
        if (start.length() != end.length()) return false;
        if (n < 2) {
            return start.equals(end);
        }
        while (j < n) {

            if (start.charAt(i) != end.charAt(i)) {
                if (start.charAt(i) == 'X' && start.charAt(j) == 'L') {
                    if (end.charAt(j) == 'X' && end.charAt(i) == 'L') {
                        i += 2;
                        j += 2;
                    } else return false;
                } else if (start.charAt(i) == 'R' && start.charAt(j) == 'X') {
                    if (end.charAt(j) == 'X' && end.charAt(i) == 'R') {
                        i += 2;
                        j += 2;
                    } else return false;
                } else return false;
            } else {
                i++;
                j++;
            }
        }
        return true;

    }
}
