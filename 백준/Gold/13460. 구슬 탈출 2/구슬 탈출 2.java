import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;     // 빨강, 파랑 두 위치 기반으로 검증
    static int holeX, holeY;            // 구멍의 위치
    static Marble blue, red;

    // 상, 우, 하, 좌 -> 시계방향
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        // board 만들기
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'O') {
                    holeX = i;
                    holeY = j;
                } else if (board[i][j] == 'B') {
                    blue = new Marble(0, 0, i, j, 0);
                } else if (board[i][j] == 'R') {
                    red = new Marble(i, j, 0, 0, 0);
                }
            }
        }
        System.out.println(bfs());
        br.close();
    }

    public static int bfs() {
        Queue<Marble> queue = new LinkedList<>();
        // count는 이동 횟수 new Marble은 이동하는 상황 나타내는 것?
        queue.add(new Marble(red.rx, red.ry, blue.bx, blue.by, 1));
        visited[red.rx][red.ry][blue.rx][blue.ry] = true;   // 방문했으므로 true

        while (!queue.isEmpty()) {
            Marble marble = queue.poll();

            int curRx = marble.rx;
            int curRy = marble.ry;
            int curBx = marble.bx;
            int curBy = marble.by;
            int curCnt = marble.count;

            // 먼저, 이동 횟수가 10 초과이므로 실패이다.
            if (curCnt > 10) {
                return -1;
            }

            // 상, 우, 하, 좌 방향으로 # 만나기까지 이동한다. (위에서 정한 방향을 생각한다)
            for (int i = 0; i < 4; i++) {
                int newRx = curRx;
                int newRy = curRy;
                int newBx = curBx;
                int newBy = curBy;

                boolean isRedHole = false;
                boolean isBlueHole = false;

                // 빨간 구슬 이동 -> # 벽을 만날 때까지 이동
                while (board[newRx + dx[i]][newRy + dy[i]] != '#') {
                    newRx += dx[i];
                    newRy += dy[i];

                    // 이동 중 hole을 만날 때
                    if (newRx == holeX && newRy == holeY) {
                        isRedHole = true;
                        break;
                    }
                }

                // 파란 구슬도 같이 이동 -> # 벽을 만날 때까지 이동
                /*
                while (board[newBx + dx[i]][newBy = dy[i]] != '#') {
                    newBx += dx[i];
                    newBy += dy[i];

                    // 이동 중 hole을 만남
                    if (newBx == holeX && newBy == holeY) {
                        isBlueHole = true;
                        break;
                    }
                }

                 */

                while(board[newBx + dx[i]][newBy + dy[i]] != '#') {
                    newBx += dx[i];
                    newBy += dy[i];

                    // 이동 중 구멍을 만날 경우
                    if(newBx == holeX && newBy == holeY) {
                        isBlueHole = true;
                        break;
                    }
                }

                // 파란 구슬이 빠진 경우
                if (isBlueHole) {
                    continue;       // 파란 구슬이 빠지면 실패지만 남은 다른 좌표도 보기 위해 일단 보류
                }
                // 빨간 구슬만 구멍에 빠진 경우
                if (isRedHole && !isBlueHole) {
                    return curCnt;      // 몇번 안에 빠졌는지
                }

                // 둘 다 구멍에 빠지지 않았고 이동할 위치가 같은 경우 -> 위치 조정 필요
                if (newRx == newBx && newRy == newBy) {
                    // (-1, 0) 왼으로 기울이기 -> 더 큰 x를 가지는 쪽이 뒤로 간다.(왼쪽으로 밀어내기)
                    if (i == 0) {
                        if (curRx > curBx) newRx -= dx[i];
                        else newBx -= dx[i];
                    }
                    // (0, 1)일 때 -> 위로 기울이기 -> 더 큰 y를 가지는 쪽이 위(뒤)로 간다.
                    else if (i == 1) {
                        if (curRy < curBy) newRy -= dy[i];
                        else newBy -= dy[i];
                    }
                    // (1, 0)일 때 -> 오른쪽으로 기울이기 -> 더 큰 x를 가지는 쪽이 오른쪽(뒤)로 간다.
                    else if (i == 2) {
                        if (curRx < curBx) newRx -= dx[i];
                        else newBx -= dx[i];
                    }
                    // (0, 1)일 때 -> 아래로 기울이기 -> 더 큰 y를 갖는 쪽이 아래로 간다.
                    // else if (i == 3) {
                    else {
                        if (curRy > curBy) newRy -= dy[i];
                        else newBy -= dy[i];
                    }
                }
                // 두 구슬이 이동할 위치가 처음 방문하는 곳인 경우에 이동한다.
                if (!visited[newRx][newRy][newBx][newBy]) {
                    visited[newRx][newRy][newBx][newBy] = true;
                    queue.add(new Marble(newRx, newRy, newBx, newBy, curCnt + 1));
                }
            }
        }
        return -1;
    }
}

// 구슬 클래스
class Marble {
    // Red
    int rx;
    int ry;
    // Blue
    int bx;
    int by;
    int count;

    Marble(int rx, int ry, int bx, int by, int count) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.count = count;
    }
}