import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int map[][];
    static boolean visited[][];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int MAX = 0;
    static int answer = 1;
    static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());
                MAX = Math.max(height, MAX);
                map[i][j] = height;
            }
        }

        for (int h = 1; h <= MAX; h++) {
            answer = Math.max(answer, solve(h));
        }

        sb.append(answer);
        System.out.println(sb);
    }

    private static int solve(int h) {
        int count = 0;

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 방문하지 않았고, 높이가 지정된 것보다 높다면
                if (!visited[i][j] && map[i][j] > h) {
                    count++;
                    BFS(i, j, h);
                }
            }
        }
        return count;
    }

    private static void BFS(int y, int x, int h) {
        queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[y][x] = true;       // 방문 표시

        while (!queue.isEmpty()) {
            Point now_point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int now_y = now_point.y + dy[i];
                int now_x = now_point.x + dx[i];

                // 범위 밖에 있거나 방문한 지점이라면!
                if (now_x < 0 || now_x > N - 1 || now_y < 0 || now_y > N - 1) {
                    continue;
                }
                if (visited[now_y][now_x]) {
                    continue;
                }
                if (map[now_y][now_x] > h) {
                    queue.add(new Point(now_x, now_y));
                    visited[now_y][now_x] = true;
                }
            }
        }
    }
}