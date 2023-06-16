import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] paper;
    static boolean[][] visited;
    static int count = 0;
    static int max_width = 0;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 1 && !visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                    // BFS 시작
                    max_width = Math.max(max_width, bfs(i, j));
                }
            }
        }

        sb.append(count).append("\n");
        sb.append(max_width);

        System.out.println(sb);
    }

    private static int bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        int new_y, new_x;
        int width = 0;

        while (!queue.isEmpty()) {
            width++;
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                new_y = now[0] + dy[i];
                new_x = now[1] + dx[i];

                if (new_x < 0 || new_x >= m || new_y < 0 || new_y >= n) {
                    continue;
                }

                if (visited[new_y][new_x]) {
                    continue;
                }

                if (paper[new_y][new_x] == 1) {
                    visited[new_y][new_x] = true;
                    queue.add(new int[]{new_y, new_x});
                }
            }
        }

        return width;
    }
}
