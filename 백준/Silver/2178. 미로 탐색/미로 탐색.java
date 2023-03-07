import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    // 상, 우, 하, 좌 -> 시계방향
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 정점 수
        M = Integer.parseInt(st.nextToken());   // 간선 수

        map = new int[N][M];

        // 미로를 생성한다.
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        visited = new boolean[N][M];
        visited[0][0] = true;

        bfs(0, 0);
        //시작 점부터
        System.out.println(map[N - 1][M - 1]);
    }

    public static void bfs(int x, int y) {

        // 좌표를 넣어준다.
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            // 4방향 모두 비교
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                // 이동할 수 없을 때 => 다른 방향 확인
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                    continue;

                // 이미 방문했거나, 0이라서 이동할 수 없을 때 => 다른 방향 확인
                if (visited[nextX][nextY] || map[nextX][nextY] == 0)
                    continue;

                // 추후에 이동할 큐
                q.add(new int[]{nextX, nextY});
                map[nextX][nextY] = map[curX][curY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }
}