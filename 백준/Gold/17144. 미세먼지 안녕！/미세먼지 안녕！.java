import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T;
    static int[][] room;
    static int[][] arr;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static List<Integer> airCleaner;
    static int temp = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());   // 7
        C = Integer.parseInt(st.nextToken());   // 8
        T = Integer.parseInt(st.nextToken());   // 1

        room = new int[R][C];
        airCleaner = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1) {
                    airCleaner.add(i);
                }
            }
        }

        for (int t = 0; t < T; t++) {
            arr = new int[R][C];

            // 확산
            for (int y = 0; y < R; y++) {
                for (int x = 0; x < C; x++) {
                    // 공기청정기를 만난 경우
                    if (room[y][x] == -1) {
                        continue;
                    }

                    // 아무것도 없는 경우
                    if (room[y][x] == 0) {
                        continue;
                    }

                    int amount = room[y][x] / 5;    // 나눌 수 있는 미세먼지의 양
                    int spread_dust = 0;

                    // 동서남북으로 갈 수 있는지 확인하기
                    for (int k = 0; k < 4; k++) {
                        int new_y = y + dy[k];
                        int new_x = x + dx[k];
                        spread_dust += togo(new_y, new_x, amount);
                    }

                    arr[y][x] -= spread_dust;

//                    if ((room[y][x] - arr[y][x]) < 0) {
//                        arr[y][x] = 0;
//                    }
                }
            }

            for (int y = 0; y < R; y++) {
                for (int x = 0; x < C; x++) {
                    room[y][x] += arr[y][x];
                    if (y == airCleaner.get(0) && x == 0) {
                        continue;
                    }

                    if (y == airCleaner.get(1) && x == 0) {
                        continue;
                    }

                    if (room[y][x] < 0) {
                        room[y][x] = 0;
                    }
                }
            }

            // 순환
            int up = airCleaner.get(0);

            int start_y = up - 1;
            int start_x = 0;

            for (int i = up - 1; i > 0; i--) {
                room[start_y][start_x] = room[start_y - 1][start_x];
                start_y -= 1;
            }

            for (int i = 0; i < C - 1; i++) {
                room[start_y][start_x] = room[start_y][start_x + 1];
                start_x += 1;
            }

            for (int i = 0; i < up; i++) {
                room[start_y][start_x] = room[start_y + 1][start_x];
                start_y += 1;
            }

            for (int i = C; i > 1; i--) {
                room[start_y][start_x] = room[start_y][start_x - 1];
                start_x -= 1;
            }

            room[start_y][start_x + 1] = 0;

            int down = airCleaner.get(1);

            start_y = down + 1;
            start_x = 0;

            for (int i = down + 1; i < R - 1; i++) {
                room[start_y][start_x] = room[start_y + 1][start_x];
                start_y += 1;
            }

            for (int i = 0; i < C - 1; i++) {
                room[start_y][start_x] = room[start_y][start_x + 1];
                start_x += 1;
            }

            for (int i = R - 1; i > down; i--) {
                room[start_y][start_x] = room[start_y - 1][start_x];
                start_y -= 1;
            }

            for (int i = C - 1; i > 0; i--) {
                room[start_y][start_x] = room[start_y][start_x - 1];
                start_x -= 1;
            }

            room[start_y][start_x + 1] = 0;
        }

        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sum += room[i][j];
            }
        }

        System.out.println(sum + 2);
    }

    private static int togo(int y, int x, int amount) {
        if (y < 0 || y >= R || x < 0 || x >= C) {
            return 0;
        }

        if (room[y][x] == -1) {
            return 0;
        }

        arr[y][x] += amount;
        return amount;
    }
}