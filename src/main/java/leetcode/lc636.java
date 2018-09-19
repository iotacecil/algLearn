package leetcode;

import java.util.*;

public class lc636 {
    /**
     * 15%
     * 输入 n = 2
     logs =
     ["0:start:0",
     "1:start:2",
     "1:end:5",
     "0:end:6"]
     * @param n
     * @param logs
     * @return
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        String[] s = logs.get(0).split(":");
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(Integer.parseInt(s[0]));
        int[] res = new int[n];
        int time = Integer.parseInt(s[2]);
        res[stack.peek()] = time;
        int[] start = new int[n];
        start[stack.peek()] = time;

        for (int i = 1; i < logs.size(); i++) {
            s = logs.get(i).split(":");

            if(s[1].equals("start")){

                if(!stack.isEmpty())
                    res[stack.peek()]+=(Integer.parseInt(s[2])-start[stack.peek()]);
                stack.push(Integer.parseInt(s[0]));
                start[stack.peek()] = Integer.parseInt(s[2]);


            }
            else if(s[1].equals("end")){
                res[stack.peek()]+=(Integer.parseInt(s[2])-start[stack.peek()]+1);
                stack.pop();
                if(!stack.isEmpty())
                start[stack.peek()] = Integer.parseInt(s[2])+1;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int n = 2;
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");

        List<String> list = Arrays.asList(
                "0:start:0",
                "0:end:0",
                "1:start:1",
                "1:end:1",
                "2:start:2",
                "2:end:2",
                "2:start:3",
                "2:end:3");
        lc636 sl = new lc636();
        System.out.println(Arrays.toString(sl.exclusiveTime(3, list)));
    }
}
