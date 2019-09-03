package niuke;

import java.util.*;
//进 1 2 3
public class 火车进站 {
    private static Stack<String> stack1=new Stack<String>();
    private static Stack<String> stack2=new Stack<String>();
    private static List<String> list=new ArrayList<String>();

    public static void ff(String str){
        System.out.println(str);
        System.out.println("stk1"+stack1);
        System.out.println("stk2"+stack2);
        //没进栈和栈中都空了
        if(stack1.isEmpty()&&stack2.isEmpty()){
            list.add(str.trim());
            System.out.println(list);
            return;
        }
        // 尝试出栈
        if(!stack2.isEmpty()){
            String str1=stack2.pop();
            System.out.println("pop"+str1);

            ff(str+" "+str1);
            System.out.println("递归回来"+str1+"到stk2");
            stack2.push(str1);
        }
        // 尝试进站，先放到站里等着出站
        if(!stack1.isEmpty()){
            String str2=stack1.pop();
            stack2.push(str2);
            System.out.println("将"+str2+"从stk1放到stk2");
            ff(str);
            stack2.pop();
            stack1.push(str2);
            System.out.println("递归回来"+str2+"从stk2放到stk1");

        }
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            scanner.nextLine();
            String str=scanner.nextLine();
            String[] ss=str.split(" ");
            for(int i=ss.length-1;i>=0;i--)
                stack1.push(ss[i]);
            ff("");
//            Collections.sort(list);
            for(String s:list)
                System.out.println(s);
        }

    }
}
