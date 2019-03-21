package gfg;
/*

m个芒果，n个人，如果物品和人都是相同的
用n个人划分芒果，需要n-1个划分。 所有芒果的排列和划分的排列一共是(m+n-1)!种排列。
因为芒果是相同的，而且人也是相同的，所以把相同的分法去掉就是(m+n-1)!/((n-1)!\*(m)!)
 */
public class MmongoNpeople {

    private static int binomial_coefficient(int m,int n){
        int res = 1;
        if(m > n-m){
            m = n-m;
        }
        for (int i = 0; i < m; i++) {
            res *= (n-i);
            res /= (i+1);
        }
        return res;
    }

    public static int identicalItemPeople(int m,int n){
        if(m<n)return 0;
        int way = binomial_coefficient(n-1, n-1+m);
        return way;
    }
    public static void main(String[] args) {
        // 4*3*2*1/(3*2*1) = 4
        System.out.println(identicalItemPeople(3, 2));

    }
}
