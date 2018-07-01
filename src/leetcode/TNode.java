package leetcode;

public class TNode<Key> {

        public Key val;
        public TNode left;
        public TNode right;
        public TNode(Key key){
            this.val = key;
        }

    @Override
    public String toString() {
        return val+" ";
    }
}

