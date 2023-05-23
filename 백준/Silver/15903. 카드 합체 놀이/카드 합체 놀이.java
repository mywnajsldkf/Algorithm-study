import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static long sum;
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 3
        m = Integer.parseInt(st.nextToken());   // 1

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            priorityQueue.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            sum = 0;
            sum += priorityQueue.poll();
            sum += priorityQueue.poll();
            priorityQueue.add(sum);
            priorityQueue.add(sum);
        }

        while (!priorityQueue.isEmpty()) {
            result += priorityQueue.poll();
        }
        sb.append(result);
        System.out.println(sb);
    }
}