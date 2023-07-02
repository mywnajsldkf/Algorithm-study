import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] result;
    static boolean[][] visited;
    static int start_y, start_x;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 2) {
                    start_y = i;
                    start_x = j;
                }
                map[i][j] = value;
            }
        }

        result = new int[n][m];
        visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{start_y, start_x});
        visited[start_y][start_x] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int now_y = now[0];
            int now_x = now[1];

            for (int d = 0; d < 4; d++) {
                int new_y = now_y + dy[d];
                int new_x = now_x + dx[d];

                if (new_y >= n || new_y < 0 || new_x >= m || new_x < 0) {   // 범위 확인
                    continue;
                }

                if (visited[new_y][new_x]) {    // 방문 여부 확인
                    continue;
                }

                if (map[new_y][new_x] == 0) {
                    continue;
                }

                // 방문 표시
                visited[new_y][new_x] = true;
                result[new_y][new_x] = result[now_y][now_x] + 1;
                queue.add(new int[]{new_y, new_x});
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (result[i][j] == 0 && map[i][j] != 0) {
                    result[i][j] = -1;
                }
            }
        }

        result[start_y][start_x] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
