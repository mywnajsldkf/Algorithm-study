import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int x, y;
    static long[][] dp_toast;
    static long[][] dp_goal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        dp_toast = new long[y][x];
        // dp_goal = new int[h - y + 1][w - x + 1];
        dp_goal = new long[h - y + 1][w - x + 1];

        // toast 집까지 갈 수 있는 경우의 수
        dp_toast[0][0] = 1;
        for (int i = 1; i < y; i++) {
            dp_toast[i][0] = 1;
        }

        for (int j = 1; j < x; j++) {
            dp_toast[0][j] = 1;
        }

        for (int i = 1; i < y; i++) {
            for (int j = 1; j < x; j++) {
                dp_toast[i][j] = (dp_toast[i - 1][j] + dp_toast[i][j - 1]) % 1_000_007;
            }
        }

        // 학교까지 갈 수 있는 경우의 수
        dp_goal[0][0] = 1;
        for (int i = 1; i < h - y + 1; i++) {
            dp_goal[i][0] = 1;
        }

        for (int j = 1; j < w - x + 1; j++) {
            dp_goal[0][j] = 1;
        }

        for (int i = 1; i <= h - y; i++) {
            for (int j = 1; j <= w - x; j++) {
                dp_goal[i][j] = (dp_goal[i - 1][j] + dp_goal[i][j - 1]) % 1_000_007;
            }
        }

//        sb.append(dp_toast[y - 1][x - 1]).append("\n");
//        sb.append(dp_goal[h - y][w - x]).append("\n");

        sb.append(dp_toast[y - 1][x - 1] * dp_goal[h - y][w - x] % 1_000_007);

        System.out.println(sb);
    }
}
