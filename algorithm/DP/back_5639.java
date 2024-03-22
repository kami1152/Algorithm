package algorithm.DP;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class back_5639 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String n = br.readLine();
            if(n == null || n.equals("")){
                break;
            }
            int num = Integer.parseInt(n);
            root.insert(num);
            
        }
        postOrder(root);

    }
    static void postOrder(Node cur){
        if(cur == null) return;
        postOrder(cur.left);
        postOrder(cur.right);
        System.out.println(cur.num);
    }
    public static class Node {
        int num;
        Node left, right;
        Node(int num){
            this.num = num;
        }
        Node(int num, Node left, Node right){
            this.num = num;
            this.left = left;
            this.right = right;
        
        }
        void insert(int n){
            if(n < this.num){
                if(this.left == null) this.left = new Node(n);
                else this.left.insert(n);
            }else{
                if(this.right ==null) this.right=new Node(n);
                else this.right.insert(n);
            }
        }


    }
    
}
