import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static boolean[] visited;
    static Queue<int[]> queue;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        min = Integer.MAX_VALUE;

        visited = new boolean[100_001];
        queue = new LinkedList<>();

        // now_x, from
        queue.add(new int[]{N, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int now_x = now[0];
            int time = now[1];

            visited[now_x] = true;

            if (now_x == K) {
                min = Math.min(min, time);
            }

            if (now_x * 2 <= 100_000 && !visited[now_x * 2]) {
                queue.add(new int[]{now_x * 2, time});
            }

            if (now_x - 1 >= 0 && !visited[now_x - 1]) {
                queue.add(new int[]{now_x - 1, time + 1});
            }

            if (now_x + 1 <= 100_000 && !visited[now_x + 1]) {
                queue.add(new int[]{now_x + 1, time + 1});
            }
        }

        sb.append(min);
        System.out.println(sb);
    }
}