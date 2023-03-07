import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static Queue<Integer> queue;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        visited = new int[100001];

        queue.add(N);

        if (N == K) {
            System.out.println("0");
        } else {
            bfs(N);
        }
    }

    private static void bfs(int n) {
        queue.add(n);
        visited[n] = 1;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = temp - 1;
                } else if (i == 1) {
                    next = temp + 1;
                } else {
                    next = temp * 2;
                }
                if (next == K) {
                    System.out.println(visited[temp]);
                    return;
                }
                if (next > 0 && next < visited.length && visited[next] == 0) {
                    queue.add(next);
                    visited[next] = visited[temp] + 1;
                }
            }
        }
    }
}