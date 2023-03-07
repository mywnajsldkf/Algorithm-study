import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, N;
    static int[][] sticker;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());   // 길이

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            sticker = new int[2][N + 1];
            int[][] dp = new int[2][N + 1];

            // initialize
            for (int j = 0; j < 2; j++) {
                String[] inputs = br.readLine().split(" ");
                for (int k = 1; k <= N; k++) {
                    sticker[j][k] = Integer.parseInt(inputs[k - 1]);
                }
            }

            // 첫번째 column
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            // dp[0][1] = Math.max(dp[1][0], 0) + sticker[0][1];
            // dp[1][1] = Math.max(dp[0][0], 0) + sticker[1][1];

            for (int j = 2; j <= N; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + sticker[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + sticker[1][j];
            }
            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}