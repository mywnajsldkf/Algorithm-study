import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    // static StringBuilder result;
    static String[][] map;
    static String[][] game;
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1, 1};
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1, 0};
    static Queue<Integer[]> zirye = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        map = new String[n][n];
        game = new String[n][n];

        // 지뢰의 위치
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = line[j];
                // System.out.println("map = " + map[i][j]);

                if (map[i][j].equals("*")) {
                    zirye.add(new Integer[]{i, j});
                }
            }
        }

        // 게임의 진행 상황
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                game[i][j] = line[j];
            }
        }

        // 게임 플레이하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game[i][j].equals(".")) {
                    continue;
                }

                // 방문한 곳이고, 지뢰가 없는 칸이라면
                if (game[i][j].equals("x") && map[i][j].equals(".")) {
                    game[i][j] = readInfo(i, j);
                    // System.out.println("game = " + game[i][j]);
                }

                // 방문한 곳이고, 지뢰가 있는 칸이라면
                if (game[i][j].equals("x") && map[i][j].equals("*")) {
                    while (!zirye.isEmpty()) {
                        Integer[] now = zirye.poll();
                        game[now[0]][now[1]] = "*";
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(game[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static String readInfo(int y, int x) {
        int count = 0;

        for (int i = 0; i < 8; i++) {
            int new_y = y + dy[i];
            int new_x = x + dx[i];

            // 범위 확인
            if (new_y < 0 || new_y >= n || new_x < 0 || new_x >= n) {
                continue;
            }

            // 지뢰면 count한다.
            if (map[new_y][new_x].equals("*")) {
                count++;
            }
        }
        return String.valueOf(count);
    }
}
