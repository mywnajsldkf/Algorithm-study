import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - 1]) % 1_000_000_000;
            }
        }

        sb.append(dp[n]);
        System.out.println(sb);
    }
}