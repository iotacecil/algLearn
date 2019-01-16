package courseBook.dsLearn.binarySearchTree;

import java.util.Collections;

public class BST<T extends Comparable<T>> {
    // static是类的一部分 要声明具体的T类型
    public static <T extends Comparable<T>> BST<T> newEmptyBST() {
        return new BST<T>();
    }

    private class Node<T> {
        Collections.sort();
        public T value;
        public Node<T> left;
        public Node<T> right;

        public Node(T value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T value) {
        if (root == null) {
            root = new Node(value);
            size++;
        } else {
            add(root, value);
        }
    }

    private void add(Node node, T value) {
        if (value.equals(node.value)) {
            return;
        } else if (value.compareTo((T) node.value) < 0) {

        }
    }
}
