import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[] numbers;
    static int index;
    static int r, c;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Point> queue;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        queue = new LinkedList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            map[r - 1][c - 1] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    queue.add(new Point(j, i));
                    visited[i][j] = true;
                    int count = bfs();
                    result = Integer.max(result, count);
                }
            }
        }

        sb.append(result);
        System.out.println(sb);
    }

    private static int bfs() {
        int count = 1;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int y = point.y;
            int x = point.x;

            for (int d = 0; d < 4; d++) {
                int new_y = y + dy[d];
                int new_x = x + dx[d];

                if (new_x < 0 || new_x >= M || new_y < 0 || new_y >= N) {
                    continue;
                }

                if (visited[new_y][new_x]) {
                    continue;
                }

                if (map[new_y][new_x] == 1) {
                    queue.add(new Point(new_x, new_y));

                    visited[new_y][new_x] = true;
                    count += 1;

                }
            }
        }

        return count;
    }

}
