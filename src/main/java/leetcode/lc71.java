package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc71 {

    public String simplifyPath2(String path) {
        Deque<String> paths = new ArrayDeque<>();
        int n = path.length();
        int idx = 0;
        while (idx < n) {
            char c = path.charAt(idx);

            String p = "";
            if (c == '/') {
                idx++;
                while (idx < n && p.length() < 1 && path.charAt(idx) == '/') {
                    idx++;
                }

//                System.out.println(idx);
                while (idx < n && path.charAt(idx) != '/') {
                    p += path.charAt(idx++);
                }
                if (idx == n) {
                    if (paths.isEmpty() && p.length() < 1 || p.equals(".") || p.equals(".."))
                        return "/";
                    else break;
                    // break;
                }
            }
//            System.out.println(p);

            if (p.equals("..")) {
                if (!paths.isEmpty())
                    paths.pop();
                continue;
            } else if (p.equals(".")) continue;
            paths.push("/" + p);
        }
        StringBuilder sb = new StringBuilder();
        for (String str : paths) {
            sb.insert(0, str);
        }
        return sb.toString();

    }

    // 29.53%
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < split.length; i++) {
            if( split[i].equals(".."))
            {   if(!stack.isEmpty())
                stack.pop();

            }else if(!split[i].equals(".") && !split[i].equals("")){
                stack.push(split[i]);
            }
        }

        if(stack.isEmpty()){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        int len = stack.size();
        for (int i = 0; i < len; i++) {

           sb.insert(0,"/"+stack.pop());


        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String path1 = "/home/";
        String path5 = "/../";
        String path6 = "/home//foo/";
        String path2 = "/a/./b/../../c/";
        String path3 = "/a/../../b/../c//.//";
        String path4 = "/a//b////c/d//././/..";
        lc71 sl = new lc71();
        System.out.println(sl.simplifyPath2(path1));
        System.out.println(sl.simplifyPath2(path5));
//        System.out.println(sl.simplifyPath(path6));
//        System.out.println(sl.simplifyPath(path3));
        System.out.println(sl.simplifyPath2(path2));
//        System.out.println(sl.simplifyPath(path4));

    }
}
