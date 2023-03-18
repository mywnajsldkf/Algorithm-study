import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int M, N;
    static boolean[][] visited;
    static int[][] tomatos;
    static Queue<int[]> queue = new LinkedList<>();

    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomatos = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatos[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatos[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            // 동서남북 살핀다.
            for (int i = 0; i < 4; i++) {
                int now_y = now[0] + dy[i];
                int now_x = now[1] + dx[i];

                // 범위 밖이라면 -> continue
                if (now_y < 0 || now_x < 0 || now_y >= N || now_x >= M) {
                    continue;
                }

                // -1 이라면
                if (tomatos[now_y][now_x] == -1) {
                    visited[now_y][now_x] = true;
                }

                // 0 이고, 방문하지 않았다면 -> queue에 넣는다.
                if (tomatos[now_y][now_x] == 0 && !visited[now_y][now_x]) {
                    queue.add(new int[]{now_y, now_x});
                    visited[now_y][now_x] = true;
                    tomatos[now_y][now_x] = tomatos[now[0]][now[1]] + 1;
                }
            }
        }

        int count = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatos[i][j] == 0) {
                    sb.append(-1);
                    System.out.println(sb);
                    System.exit(0);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (count < tomatos[i][j]) {
                    count = tomatos[i][j];
                }
            }
        }
        sb.append(count - 1);
        System.out.println(sb);
    }
}