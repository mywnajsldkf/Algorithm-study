import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] numbers;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        numbers = new int[n + 1];
        dp = new int[k + 1];

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        // 0일 때는 방법이 한 가지이다.
        // dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = numbers[i]; j <= k; j++) {
                dp[j] = dp[j] + dp[j - numbers[i]];
            }
        }
        System.out.println(dp[k]);
    }
}