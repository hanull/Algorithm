package boj.boj11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Stack<Integer> stack = new Stack<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(stoi(st.nextToken()));
        }

        int total = pq.peek();
        stack.add(pq.poll());
        while (!pq.isEmpty()) {
            stack.add(stack.peek() + pq.poll());
            total += stack.peek();
        }
        System.out.println(total);
    }

    static int stoi(String input) {
        return Integer.parseInt(input);
    }

}
