import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] copyMap;
    static int[] output;
    static List<Cctv> cctvList = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int type = Integer.parseInt(str[j]);
                map[i][j] = type;
                if (type != 0 && type != 6) { // cctv에 해당된다
                    cctvList.add(new Cctv(i, j, type));
                }
            }
        }

        // cctvList에 있는 것들로 순열을 구한다.-> 1:4, 2:2, 3:4, 4:4, 5:1
        output = new int[cctvList.size()];
        permutation(0, cctvList.size());

        System.out.println(answer);
    }

    public static void permutation(int depth, int r) {
        if (depth == r) {
            copyMap = new int[N][M];
            for (int i = 0; i < map.length; i++) {
                System.arraycopy(map[i], 0, copyMap[i], 0, map[i].length);
            }

            // cctv번호와 순열로 뽑혀진 방향에 맞는 상하좌우 방향 설정
            for (int i = 0; i < cctvList.size(); i++) {
                direction(cctvList.get(i), output[i]);
            }

            getBlindSpot();
            return;

        }

        for (int i = 0; i < 4; i++) {
            output[depth] = i;  // 방향
            permutation(depth+1, r);
        }
    }

    public static void direction(Cctv cctv, int d) {
        int cctvType = cctv.type;

        if (cctvType == 1) {
            if (d == 0) {
                watch(cctv, 0);
            } else if (d == 1) {
                watch(cctv, 1);
            } else if (d == 2) {
                watch(cctv, 2);
            } else if (d == 3) {
                watch(cctv, 3);
            }
        } else if (cctvType == 2) {
            if (d == 0 || d == 2) {
                watch(cctv, 0);
                watch(cctv, 2);
            } else if (d == 1 || d == 3) {
                watch(cctv, 1);
                watch(cctv, 3);
            }
        } else if (cctvType == 3) {
            if (d == 0) {
                watch(cctv, 0);
                watch(cctv, 1);
            } else if (d == 1) {
                watch(cctv, 1);
                watch(cctv, 2);
            } else if (d == 2) {
                watch(cctv, 2);
                watch(cctv, 3);
            } else if (d == 3) {
                watch(cctv, 3);
                watch(cctv, 0);
            }
        } else if (cctvType == 4) {
            if (d == 0) {
                watch(cctv, 3);
                watch(cctv, 0);
                watch(cctv, 1);
            } else if (d == 1) {
                watch(cctv, 0);
                watch(cctv, 1);
                watch(cctv, 2);
            } else if (d == 2) {
                watch(cctv, 1);
                watch(cctv, 2);
                watch(cctv, 3);
            } else if (d == 3) {
                watch(cctv, 2);
                watch(cctv, 3);
                watch(cctv, 0);
            }
        } else if (cctvType == 5) {
            watch(cctv, 0);
            watch(cctv, 1);
            watch(cctv, 2);
            watch(cctv, 3);
        }
    }

    public static void watch(Cctv cctv, int type) {
        // bfs
        Queue<Cctv> queue = new LinkedList<>();
//        copyMap[cctv.y][cctv.x] = -1;   // 방문 표시
        queue.add(cctv);

        while (!queue.isEmpty()) {
            Cctv nowCctv = queue.poll();
            int nextY = nowCctv.y + dy[type];
            int nextX = nowCctv.x + dx[type];

            // 범위 밖이면
            if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) {
                break;  // 방향이 정해져있으니까
            }

            if (copyMap[nextY][nextX] == 6) {
                break;  // 해당 방향으로 더이상 직진 불가
            }

            if (copyMap[nextY][nextX] == 0) {   // 아직 방문 X
                copyMap[nextY][nextX] = -1; // 방문 표시
                queue.add(new Cctv(nextY, nextX, type));    //
            } else {    // 이미 방문했다면, 다른 cctv가 있는 칸이라면
                queue.add(new Cctv(nextY, nextX, type));
            }
        }
    }

    public static void getBlindSpot() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    count++;
                }
            }
        }

        answer = Math.min(answer, count);
    }
}

class Cctv {
    int y, x;
    int type;

    public Cctv(int y, int x, int type) {
        this.y = y;
        this.x = x;
        this.type = type;
    }
}
