package courseBook.dsLearn;

public class substringbackuTest {
    public static void main(String[] args) {

        substringbacku sl = new substringbacku();
        System.out.println(sl.serachByKMP("mississippi", "issip"));
        System.out.println(sl.serachByDfa("mississippi", "issip"));
//        int a = 2;
//        System.out.println(Integer.toBinaryString(a));
//        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//        StringBuilder sb1 =new StringBuilder();
//        StringBuilder sb2 =new StringBuilder();
//        Random random=new Random(1024);
//        String[] sources = new String[50];
//        String[] targets = new String[50];
//        System.out.println("boyer"+searchBoyer("hello", "ll"));
//
//        for (int k = 0; k <sources.length ; k++) {
//
//
//            int length = random.nextInt(1000);
//            for (int i = 0; i < length; i++) {
//                int number = random.nextInt(62);
//                sb1.append(str.charAt(number));
//                if (i >= length*3/5&&i <= length*4/5)
//                    sb2.append(str.charAt(number));
//            }
//            sources[k] = sb1.toString();
//            targets[k] = sb2.toString();
//        }
////        System.out.println(Arrays.toString(targets));
////        System.out.println(sources[0].length());
////        System.out.println(targets[0].length());
//        long start = System.currentTimeMillis();
//        for(int i=0;i<sources.length;i++){
////            serachByDfa(sources[i],targets[i]);
//            searchBoyer(sources[i],targets[i]);
////            indexOf(sources[i],targets[i]);
//        }
//
//        long end = System.currentTimeMillis();
//        System.out.println("用时"+(end-start));
//
//        System.out.println(search("ADAC", "ABACADABRAC"));
//
//        String source = "hello";
//        String target = "ll";
//        System.out.println("DFA"+serachByDfa("aaaaa", "aaa"));
//
//        System.out.println(search( source,target));
//        System.out.println();
//
//        System.out.println(indexOf( source.toCharArray(),0,source.length(),target.toCharArray(),0,target.length(),0));
    }
}
