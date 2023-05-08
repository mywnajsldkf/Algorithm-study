import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T;
    static int N, M;
    static int a, b;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N + 1][N + 1];
            visited = new boolean[N + 1];

            Queue<Integer> queue = new LinkedList<>();

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                arr[a][b] = 1;
                arr[b][a] = 1;
            }

            queue.add(1);
            visited[1] = true;
            int count = 0;
            while (!queue.isEmpty()) {
                count += 1;
                int now = queue.poll();

                for (int j = 1; j <= N; j++) {
                    // 방문 여부 확인 및 1인지
                    if (visited[j] == false && arr[now][j] == 1) {
                        queue.add(j);
                        visited[j] = true;
                    }
                }
            }
            sb.append(count - 1);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}