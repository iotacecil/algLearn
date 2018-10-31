package leetcode;

import java.util.HashSet;
import java.util.Set;

public class lc929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        int n = emails.length;
        for(int i =0;i<n;i++){
            String[] email = emails[i].split("@");
            String local = email[0];
            int cnt = 0;
            char[] localchar = new char[local.length()];
            for (int j = 0; j < local.length(); j++) {
                if(local.charAt(j)=='.')continue;
                if(local.charAt(j)=='+')break;
                localchar[cnt++] = local.charAt(j);
            }

            local = new String(localchar,0,cnt);
            set.add(local+"@"+email[1]);
        }

        return set.size();
    }

    public static void main(String[] args) {
        String[] emails = new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        lc929 sl = new lc929();
        int i = sl.numUniqueEmails(emails);
        System.out.println(i);
    }
}
