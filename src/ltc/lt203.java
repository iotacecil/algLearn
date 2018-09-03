package ltc;

public class lt203 {
    public void modify(lt439.SegmentTreeNode root, int index, int value) {
        if(root.start>index||root.end<index)return;
        if(root.start == index&&root.end==index){
            root.max = value;
            return;
        }
        int mid = (root.start+root.end)/2;
        if(mid>=index){
            modify(root.left,index ,value );
        }else{
            modify(root.right,index ,value );
        }
        root.max = Math.max(root.left.max,root.right.max);
    }

    public static void main(String[] args) {
        lt439 sl = new lt439();
        lt439.SegmentTreeNode root = sl.build(new int[]{2,1,0,3});
        lt203 sl203 = new lt203();
        sl203.modify(root, 2, 4);
        System.out.println(root);
    }
}
