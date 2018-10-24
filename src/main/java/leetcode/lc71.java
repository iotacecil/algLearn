package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class lc71 {
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
        System.out.println(sl.simplifyPath(path1));
        System.out.println(sl.simplifyPath(path5));
        System.out.println(sl.simplifyPath(path6));
        System.out.println(sl.simplifyPath(path3));
        System.out.println(sl.simplifyPath(path2));
        System.out.println(sl.simplifyPath(path4));

    }
}
