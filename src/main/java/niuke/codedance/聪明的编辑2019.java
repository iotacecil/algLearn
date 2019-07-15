package niuke.codedance;

import java.util.Scanner;

/*
链接：https://www.nowcoder.com/questionTerminal/42852fd7045c442192fa89404ab42e92?orderByHotValue=0&mutiTagIds=134_665&page=1&onlyReference=false
来源：牛客网

1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
 */
public class 聪明的编辑2019 {

    public static String edit(String str){
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i = 0; i <str.length() ; i++) {
           if(idx>=2&&str.charAt(i)==sb.charAt(idx-1)&&str.charAt(i)==sb.charAt(idx-2)){
                continue;
            }else if(idx>=3 && str.charAt(i)==sb.charAt(idx-1) && sb.charAt(idx-2) ==sb.charAt(idx-3)){
                continue;
            }else{
               sb.append(str.charAt(i));
               idx++;
           }

        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nn = sc.nextInt();
        for (int i = 0; i <nn ; i++) {
            String str = sc.next();
            System.out.println(edit(str));

        }

    }
}
