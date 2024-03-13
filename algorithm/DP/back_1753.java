package algorithm.DP;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int end, weight;

    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class back_1753 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 100_000_000;
    static int v,e,k;
    static List<Node>[] nodelist;
    static int[] result;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        nodelist = new ArrayList[v + 1];
        result = new int[v + 1];

        Arrays.fill(result, INF);

        for(int i = 1; i <= v; i++){
            nodelist[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            nodelist[start].add(new Node(end, weight));
        }

        StringBuilder sb = new StringBuilder();

        dijkstra(k);
        for(int i = 1; i <= v; i++){
            if(result[i] == INF) sb.append("INF\n");
            else sb.append(result[i] + "\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void dijkstra(int start){
       PriorityQueue<Node> queue = new PriorityQueue<>();
       boolean[] check = new boolean[v + 1];
       queue.add(new Node(start, 0));
       result[start] = 0;

       while(!queue.isEmpty()){
           Node curNode = queue.poll();
           int cur = curNode.end;

           if(check[cur] == true) continue;
           check[cur] = true;

           for(Node node : nodelist[cur]){
               if(result[node.end] > result[cur] + node.weight){
                   result[node.end] = result[cur] + node.weight;
                   queue.add(new Node(node.end, result[node.end]));
               }
           }
       }
    }
}