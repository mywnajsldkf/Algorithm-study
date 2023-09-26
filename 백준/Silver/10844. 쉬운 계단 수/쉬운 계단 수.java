import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[][] dp;
    final static int divider = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][10];   // N 자릿수에서 마지막 자릿값

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;   // 1자릿수에는 경우의 수 개수가 1만 있다.
        }

        // 두번째 자릿수부터 N까지 탐색
        for (int i = 2; i <= N; i++) {
            // i번째 자릿수의 자릿값들을 탐색(0~9)
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i - 1][1] % divider;    // 이전 자릿수의 1만 가능
                } else if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % divider;    // 이전 자릿수의 8만 가능
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % divider;
                }
            }
        }
        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
        }
        System.out.println(result % divider);
    }
}