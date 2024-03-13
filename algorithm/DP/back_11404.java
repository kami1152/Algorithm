package algorithm.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class back_11404 {
    List<Node> list = new ArrayList<>();

    public back_11404() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M ; i++){

        }
        
    }



    public static class Node {
        public int end;
        public int weight;
        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }  
        
    }
}
