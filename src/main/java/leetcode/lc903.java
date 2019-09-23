package leetcode;

public class lc903 {


    public static void main(String[] args) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        map.put(null, null);
//        System.out.println(map.get(null));
//        Calendar ca = Calendar.getInstance();
//        ca.setTime(new Date(2019,2,2));
//        System.out.println(ca.get(Calendar.DAY_OF_YEAR));

//        ArrayList<String> l1 = new ArrayList<>();
//        ArrayList<Integer> l2 = new ArrayList<>();
//        l1.add("1");
//        l2.add(1);
//        System.out.println(l1.get(0).getClass());
//        System.out.println(l2.get(0).getClass());
//        System.out.println(l1.getClass() == l2.getClass());

        int i = 0;
        int res = 1;
        while (true){
            try {
                res += res/(i++);
                System.out.println("no exce");
            }catch (Exception e){
                System.out.println("zero");
            }finally {
                System.out.print("final");
                System.out.println(i);
                if(i == 2)break;
            }
        }

    }
}
