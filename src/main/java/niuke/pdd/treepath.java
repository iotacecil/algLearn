package niuke.pdd;

import java.util.*;

/**

不会
 链接：https://www.nowcoder.com/questionTerminal/bc858b8477c44951bfde0c5941396622?orderByHotValue=1&page=1&onlyReference=false
 来源：牛客网

 输入的第一行是一个正整数m，0<m<=9900，表示布置花灯的道路的总长度的上限。

 输入的第二行是一个正整数n，n<=100，表示城市的个数。

 紧接着是n-1行输入，每行三个正整数u、v、d，表示下标为u的城市有一条长度为d的道路通向它的一个子城市v，其中0<=u<n，0<=v<n，0<d<=100。


 5
 5
 0 1 1
 0 2 2
 0 3 3
 0 4 4

 输出 5

 */

public class treepath {
    static List<Integer> dists;
    static List<HashSet<Integer>> children;
    static List<Integer> parents;
    static int limit;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        limit = sc.nextInt();
        n = sc.nextInt();
        parents = new ArrayList<>();
        children = new ArrayList<>();
        dists = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            dists.add(0 );
            parents.add(-1 );
            children.add(new HashSet<>() );
        }

        for (int i = 0; i <n-1 ; i++) {
            int u = sc.nextInt();int v = sc.nextInt();int d = sc.nextInt();
            if(d > limit)continue;
            children.get(u).add(v);
            parents.set(v,u);
            dists.set(v,d );
        }
        int root = 0;
        while (parents.get(root)!=-1)root = parents.get(root);

    }

    public static TreeSet<Integer> values(int root){
        TreeSet<Integer> set = new TreeSet<>();
        int d = dists.get(root);
        set.add(0);
        if(children.get(root).size() == 0){
            set.add(d);
            return set;
        }

        ArrayList<TreeSet<Integer>> sets = new ArrayList<>();

        for( int i : children.get( root ) ) sets.add( values( i ) );
        for( int i = 0; i < sets.size(); i ++ ) {
            for( int j : sets.get(i) )
                if( d + j <= limit ) set.add( d + j );
            for( int j = i + 1; j < sets.size(); j ++ )
                for( int m : sets.get(i) )
                    for( int n : sets.get(j) )
                        if( m + n + d <= limit ) set.add( m + n + d );
        }
        return set;
    }
}
