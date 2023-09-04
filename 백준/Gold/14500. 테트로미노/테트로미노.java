import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M, result = Integer.MIN_VALUE;
    static int[][] map;
    static boolean[][] visit;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        map = new int[N][M];
        visit = new boolean[N][M];

        // map을 만들었다.
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visit[i][j] = false;
                combi(i, j, 0, 0, map[i][j]);
            }
        }

        sb.append(result);
        System.out.println(result);
    }

    private static void combi(int y, int x, int depth, int start, int sum) {
        if (depth == 3) {
            result = Math.max(result, sum);
            return;
        }

        // 시작 지점이 달라지는 것임
        for (int d = start; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            // 범위 밖!
            if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                continue;
            }

            combi(y, x, depth + 1, d + 1, sum + map[ny][nx]);
        }
    }

    private static void dfs(int y, int x, int depth, int sum) {
        if (depth == 4) {
            result = Math.max(result, sum); // 크기 비교
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                continue;
            }

            if (visit[ny][nx]) {
                continue;
            }

            visit[ny][nx] = true;   // 방문 표시
            dfs(ny, nx, depth + 1, sum + map[ny][nx]);
            visit[ny][nx] = false;
        }
    }
}