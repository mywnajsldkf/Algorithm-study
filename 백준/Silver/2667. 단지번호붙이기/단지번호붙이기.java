import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static StringTokenizer st;
    static ArrayList<Integer> danjiCount;
    static boolean[][] visit;
    static int count;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N][N];
        danjiCount = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String st = br.readLine();
            for (int j = 0; j < N; j++) {
                // map[i][j] = Integer.parseInt(String.valueOf(st.charAt(j)));
                map[i][j] = st.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    count = 1;
                    findDanji(i, j);
                    danjiCount.add(count);
                }
            }
        }

        sb.append(danjiCount.size()).append("\n");
        Collections.sort(danjiCount);
        for (int i = 0; i < danjiCount.size(); i++) {
            sb.append(danjiCount.get(i)).append("\n");
        }
        System.out.println(sb);
    }

    private static void findDanji(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int x_new = x + dx[i];
            int y_new = y + dy[i];
            if (x_new >= 0 && y_new >= 0 && x_new < N && y_new < N) {
                if (map[x_new][y_new] == 1 && !visit[x_new][y_new]) {
                    findDanji(x_new, y_new);
                    count++;
                }
            }
        }
    }
}
