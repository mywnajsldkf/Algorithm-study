import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] array;
    static int[] dp;
    static int max = Integer.MIN_VALUE;
    static int value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        array = new int[n];
        dp = array;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], dp[i]);
        }

        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        sb.append(max);
        System.out.println(sb);
    }
}