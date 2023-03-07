import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int T;
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 0; i < T; i++) {
            int dpSize = Integer.parseInt(br.readLine());

            dp(dpSize);
            sb.append(dp[dpSize]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dp(int max) {
        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
    }
}