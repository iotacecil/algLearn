package leetcode;

import java.util.HashMap;

public class lc146 {

        int capacity;
        private HashMap<Integer,Node> map;
        Node head;
        Node tail;
        class Node{
            int key;
            int val;
            Node next;
            Node pre;
            public Node(int key,int val){
                this.key = key;
                this.val=val;
                pre=null;
                next=null;
            }
            public String toString(){
                return "node:"+key+" "+val;
            }

        }
        public lc146(int capacity) {
            this.capacity=capacity;
            map=new HashMap<>(capacity);
            head=null;
            tail=null;


        }

        public int get(int key) {
            Node gt=map.get(key);
            if(gt==null)return -1;
            if(tail!=null){
                gt.pre=tail;
                tail.next= gt;
                tail=gt;
            }
            if(gt==head){//1,1 2,2 ->

                head=head.next;
                head.pre=null;

            }
            else{ //
                gt.pre.next=gt.next;
                gt.next.pre=gt.pre;

            }
            return gt.val;

        }

        public void put(int key, int value) {
            Node gt = map.get(key);
            if(gt!=null){
                gt.val=value;

            }else {

                gt = new Node(key, value);
            }
                System.out.println("put:"+key+" "+gt);
                //1,1 2,2 |3,3
                if(head==null){head=gt;tail=gt;}
                else {

                    gt.pre = tail;
                    tail.next = gt;
                    tail = gt;

                    if (capacity == 0) {// 1,2,3,4  5 ca=5
//capacity:0
//                        map1 node:1 1
//                        map2 node:2 1
//                        头node:2 1
                        //capacity:0
//                        map1 node:1 1
//                        map2 node:2 3
//                        头node:2 3
                        //2,1 1,1 [2,3 4,1]
                        map.remove(head.key);


                        capacity++;
                        head = head.next;
                        //
                        System.out.println("removedhead" + head);
                        head.pre = null;
                    }
                }
            map.put(key,gt);//1,1

            capacity--;

                }




//            System.out.println("capacity:"+capacity);
//            map.forEach((k,v)->System.out.println("map"+k+" "+v));
//            System.out.println("头"+head);
//        }


    public static void main(String[] args) {
        lc146 list = new lc146(2);
list.get(2);
        list.put(2,6);
        list.get(1);
        list.put(1,5);
        list.put(1,2);

        System.out.println(list.get(1));
        System.out.println(list.get(2));
//        System.out.println(list.get(1));
//        list.put(3,3);
//        System.out.println(list.get(2));
//        //1,2->2,1->1,3->3,4
//        list.put(4,4);
//        System.out.println(list.get(1));

    }

}
