import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int dy[] = {1, 0, -1, 0};
    static int dx[] = {0, 1, 0, -1};
    static int count;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (isCheese()) {
            visited = new boolean[N][M];
            visited[0][0] = true;
            answer++;
            count = 0;
            DFS(0, 0);
        }

        sb.append(answer).append("\n").append(count);
        System.out.println(sb);
    }

    private static void DFS(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int n_y = y + dy[i];
            int n_x = x + dx[i];

            if (n_y < 0 || n_x < 0 || n_y > N - 1 || n_x > M - 1) {
                continue;
            }

            if (!visited[n_y][n_x]) {
                visited[n_y][n_x] = true;
                if (map[n_y][n_x] == 1) {
                    map[n_y][n_x] = 2;
                    count++;    // 다음에 지워질 치즈 개수
                } else {
                    DFS(n_y, n_x);
                }
            }
        }
    }

    private static boolean isCheese() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}