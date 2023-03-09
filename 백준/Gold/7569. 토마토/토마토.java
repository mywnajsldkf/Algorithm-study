import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int M, N, H;
    static boolean[][][] visited;
    static int[][][] tomatos;
    static Queue<Point> queue = new LinkedList<>();

    static int[] dx = {0, 1, -1, 0, 0, 0};
    static int[] dy = {1, 0, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static int day = 0;

    public static class Point {
        int x;
        int y;
        int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomatos = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomatos[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomatos[i][j][k] == 1) {
                        queue.add(new Point(k, j, i));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            visited[now.z][now.y][now.x] = true;

            for (int i = 0; i < 6; i++) {
                int nZ = now.z + dz[i];
                int nY = now.y + dy[i];
                int nX = now.x + dx[i];

                if (nX < 0 || nY < 0 || nZ < 0 ||
                        nX >= M || nY >= N || nZ >= H) {
                    continue;
                }

                if (visited[nZ][nY][nX] == false && tomatos[nZ][nY][nX] == 0) {
                    queue.add(new Point(nX, nY, nZ));
                    tomatos[nZ][nY][nX] = tomatos[now.z][now.y][now.x] + 1;
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomatos[i][j][k] == 0) {
                        sb.append(-1);
                        System.out.println(sb);
                        System.exit(0);
                    }
                    day = Math.max(day, tomatos[i][j][k]);
                }
            }
        }
        sb.append(day - 1);
        System.out.println(sb);
    }
}