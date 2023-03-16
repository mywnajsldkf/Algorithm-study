import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Integer[] dp;
    static int[] stairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        stairs = new int[N + 1];
        dp = new Integer[N + 1];

        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = stairs[0];  // 0으로 초기화
        dp[1] = stairs[1];

        if (N >= 2) {
            dp[2] = stairs[1] + stairs[2];  // 1, 2층을 모두 밟는 것이 가장 크다.
        }

        // bottom-up --> 주로 반복문으로 구현한다.
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }
        System.out.println(dp[N]);
    }
}