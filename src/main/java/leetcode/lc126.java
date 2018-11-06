package leetcode;

import jdk.internal.dynalink.beans.StaticClass;

import java.util.*;

class Qitem{
    String node;
    int pre;
    int step;
}
public class lc126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        words.add(beginWord);
        List<List<String>> rst = new ArrayList<>();
        HashMap<String,List<String>> graph = new HashMap<>();
        // pair <node,step>
        HashMap<String,Integer> pairs = new HashMap<>();
        ArrayList<String> tmp = new ArrayList<>();
        bfs(beginWord,endWord,words,graph,pairs);
        dfs(beginWord,endWord,words,graph,pairs,tmp,rst);
        return rst;
    }

    // 从set 中筛选出 步长差1的String
    private List<String> getNeib(String top,Set<String> words){
        List<String> rst = new ArrayList<>();
        char[] chs = top.toCharArray();
        for(char ch = 'a'; ch <= 'z' ; ch++ ){
            for (int i = 0; i <chs.length ; i++) {
                if(chs[i] == ch)continue;
                char old = chs[i];
                chs[i] = ch;
                if(words.contains(String.valueOf(chs))){
                    rst.add(String.valueOf(chs));
                }
                chs[i] = old;
            }
        }
        return rst;
    }

    // bfs可以找到所有 k步可达的顶点，并建立起链接， k是到达end的最少步数
    private void bfs(String start,String end,Set<String> words,HashMap<String,List<String>> graph,HashMap<String,Integer> pairs){
        for(String word : words){
            graph.put(word, new ArrayList<>());
        }
        // 队列只放node 或者结构体把step也带着
        Deque<String> que = new ArrayDeque<>();
        que.add(start);
        pairs.put(start, 0);
        while (!que.isEmpty()){
            // 这一层
            int count = que.size();
            boolean found = false;
            for (int i = 0; i < count ; i++) {
                String top = que.poll();
                int step = pairs.get(top);
                List<String> neib = getNeib(top, words);

                for(String next : neib){
                    // 构建有向图
                    graph.get(top).add(next);
                    // 记录访问过了并且当前访问的步长 不用了visit set
                    if(!pairs.containsKey(next)){
                        // 注意找到了也需要先把pair放进去
                        pairs.put(next, step+1);
                        // 如果找到了
                        if(end.equals(next)){
                            found = true;
                        }else{
                            que.add(next);
                        }
                    }
                }

                if(found)break;


            }

        }

    }

    private void dfs(String start,String end,Set<String> words,Map<String,List<String>> graph,Map<String,Integer> pairs,List<String> tmp,List<List<String>> res){
        tmp.add(start);
        if(end.equals(start))
        {
            res.add(new ArrayList<>(tmp));
        }else {
            // 从start dfs找这个最长只有k步的图， dfs的条件是1 是邻边表示差1步，2是pair中记录这个邻边是下一个step
            for(String next : graph.get(start)){
                if(pairs.get(next) == pairs.get(start) + 1){
                    dfs(next,end,words,graph,pairs,tmp,res);
                }
            }
        }
        //如果这条路走不通或者走完了，一段一段删回来
        tmp.remove(tmp.size()-1);
    }



    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");
        lc126 sl= new lc126();
        System.out.println(sl.findLadders(beginWord, endWord, list));
    }
}
