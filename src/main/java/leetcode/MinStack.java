package leetcode;

public class MinStack {
    private node head;
    private class node{
        int val;
        int min;
        node next;

        private node(int val , int min){
            this(val,min,null);
        }
        private node(int val ,int min, node next){
            this.val=val;
            this.min=min;
            this.next=next;
        }
    }

    /**
     * initialize your data structure here.
     */


    public void push(int x) {
        if(head==null){head= new node(x,x);}
        else{head = new node(x,Math.min(x,head.min),head);}
    }

    public void pop() {
        head=head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;

    }



    public static void main(String[] args) {
         MinStack obj = new MinStack();
        obj.push(1);
         obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }
}
