package niuke.mt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
10
0 0 1 2 0 5 1 2 3
1 0 0 1 0 0 1 1 0 1


使得每一个连通块内只有一个白色结点

输出样例2：
f[u]表示u子树有一个白点的方案数
g[u]表示u子树没有白点的方案数
f[u]=f[u]*g[son]+f[u]*f[son]+g[u]*f[son]
g[u]=g[u]*g[son]+g[u]*f[son]
递归终止  如果当前节点是 白色
 */
public class qiegeshu {
    static long[] f;
    static long[] g;
    final static long mod = 1000000007;
    public static void dfs(List[] tree,int[]color,int idx,int fd){
        // 白色
        if(color[idx] == 0)f[idx] = 1;
        else g[idx] = 1;
        List<Integer> nexts = tree[idx];
        for(Integer next : nexts){
            if(next == fd)continue;
            dfs(tree,color,next,idx);
            f[idx] =(f[idx]*g[next]%mod + f[next]*f[idx]%mod + g[idx] *f[next]%mod)%mod;
            g[idx] =(g[idx]*g[next]%mod + g[idx] * f[next]%mod)%mod;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i <n ; i++) {
            tree[i] = new ArrayList<>();
        }
        // 连接 当前节点 i+1和读入的father
        for (int i = 0; i <n-1 ; i++) {
            int fd = sc.nextInt();
            tree[fd].add(i+1);
            tree[i+1].add(fd);
        }
        int[] color = new int[n];
        f = new long[n];
        g = new long[n];
        // 每个节点的颜色 0 白色 1 黑色
        for (int i = 0; i <n ; i++) {
            color[i] = sc.nextInt();
        }
        dfs(tree,color,0,-1);
        System.out.println(f[0]);
    }
}
