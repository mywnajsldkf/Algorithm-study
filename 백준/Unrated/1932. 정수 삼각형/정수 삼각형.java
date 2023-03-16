import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] triangle = new int[500][500];
    static Integer[][] dp = new Integer[500][500];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1줄
        dp[0][0] = triangle[0][0];
        // 2줄
        dp[1][0] = triangle[0][0] + triangle[1][0];
        dp[1][1] = triangle[0][0] + triangle[1][1];

        if (n == 1) {
            System.out.println(dp[0][0]);
        } else if (n == 2) {
            System.out.println(Math.max(dp[1][0], dp[1][1]));
        } else {
            for (int i = 2; i < n; i++) {
                dp[i][0] = dp[i - 1][0] + triangle[i][0];
                for (int j = 1; j < i; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
                dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
            }

            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, dp[n - 1][i]);
            }
            System.out.println(max);
        }
    }
}