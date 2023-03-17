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
    static boolean[][][] visited;
    static Queue<Wall> queue = new LinkedList<>();

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2]; // 0 -> 파괴 X / 1 -> 파괴 O

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        queue.add(new Wall(0, 0, 1, false));
        System.out.println(BFS());
    }

    private static int BFS() {
        while (!queue.isEmpty()) {
            Wall now = queue.poll();

            if (now.x == M - 1 && now.y == N - 1) {
                return now.count;
            }

            // 동서 남북 살펴보기
            for (int i = 0; i < 4; i++) {
                int new_x = now.x + dx[i];
                int new_y = now.y + dy[i];
                // 범위 밖에 있다면
                if (new_x < 0 || new_y < 0 || new_x >= M || new_y >= N) {
                    continue;
                }

                // 방문하지 않았고, 0이라면(벽이 아니면)
                if (map[new_y][new_x] == 0) {
                    // 부서지지 않았고, 방문하지 않았다면
                    if (!now.isDestroyed && !visited[new_y][new_x][0]) {
                        queue.add(new Wall(new_x, new_y, now.count + 1, false));
                        visited[new_y][new_x][0] = true;
                        // 이미 부서졌고, 방문하지 않았다면
                    } else if (now.isDestroyed && !visited[new_y][new_x][1]) {
                        queue.add(new Wall(new_x, new_y, now.count + 1, true));
                        visited[new_y][new_x][1] = true;
                    }
                }

                // 방문하지 않았고, 1이라면
                if (map[new_y][new_x] == 1) {
                    // 벽을 부순 적 없다면 부술 수 있다.
                    if (!now.isDestroyed) {
                        queue.add(new Wall(new_x, new_y, now.count + 1, true));
                        visited[new_y][new_x][1] = true;
                    }
                }
            }
        }
        return -1;
    }
}

// 현재 좌표(x,y), 이전에 벽을 부순 적 있는지, 이동 횟수
class Wall {
    int x;
    int y;
    int count;
    boolean isDestroyed;

    public Wall(int x, int y, int count, boolean isDestroyed) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.isDestroyed = isDestroyed;
    }
}