import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] dp;
    static int divider = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        dp = new int[10];

        for (int i = 0; i < 10; i++) {
            dp[i] = i + 1;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < 10; j++) {
                dp[j] = (dp[j - 1] + dp[j]) % divider;
            }
        }
        sb.append(dp[9]);
        System.out.println(sb);
    }
}