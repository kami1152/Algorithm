package algorithm.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import algorithm.math.turret;

public class back_1927 {
    static int N;
    static int heapsize = 0;
    static int[] heap;
    static int count = 0;
    static List<Integer> list = new ArrayList<>();
    static PriorityQueue<Integer> que = new PriorityQueue<>();

    public back_1927() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        heap = new int[N + 1];
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (temp != 0) {
                que.add(temp);
            } else {
                if (!que.isEmpty()) {
                    System.out.println(que.poll());
                } else {
                    System.out.println(0);
                }
            }
            /*
             * if (temp != 0) {
             * 
             * list.add(temp);
             * Collections.sort(list);
             * } else {
             * System.out.println(heapfunc());
             * }
             */
        }
    }

    static void heapfunc2(int number) {
        if (number == 0 && heap[0] == 0) {
            System.out.println(0);
            return;
        }
        if (number == 0) {
            heapsize--;
            int count = 1;
            System.out.println(heap[0]);
            while (true) {
                heap[count - 1] = heap[count];
                if (heap[count + 1] == 0) {
                    heap[count] = 0;
                    break;
                }
                count++;
            }
            return;
        }
        if (heap[heapsize] == 0) {
            heap[heapsize] = number;
        } else {
            heapsort(heap);
        }

        heapsize++;
    }

    static void heapsort(int[] arr) {

        int a = 0;
        int dsort[] = new int[N + 1];
        for (int item : arr) {
            if (item != 0) {
                dsort[a] = item;
                a++;
            }
        }

        while (true) {
            int i = 0;
            boolean escape = true;
            if (dsort[i + 1] == 0) { // 2 1 3 0 0
                i = 0;
            }
            if (dsort[i] > dsort[i + 1]) {
                int temp = dsort[i];
                dsort[i] = dsort[i + 1];
                dsort[i + 1] = temp;
                escape = false;
            }
            if (escape) {
                break;
            }

            i++;

        }

    }

    static int heapfunc() {

        if (list.isEmpty()) {
            return 0;
        } else {
            return list.remove(0);
        }

    }
}
