package courseBook.dsLearn.basic;

public class preorder_inoreder {
    //todo
    private String tobackorder(String pre,String in){
        StringBuilder sb = new StringBuilder();
        char root = pre.charAt(0);
        int leftlen = in.indexOf(root);
        String preleft = pre.substring(1,leftlen);
        String preright = pre.substring(1+leftlen);
        System.out.println(preleft+" "+preright);
        String inleft = in.substring(0,leftlen);
        String inright = in.substring(leftlen+1);
        System.out.println(inleft+" "+inright);
        return "";

    }
    public static void main(String[] args) {
        String pre = "ACDEFHGB";
        String inorder = "DECAHFBG";

    }
}
