import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[2][N + 1];
        Arrays.fill(dp[0], 1);

        // dp[1][0] = 1;

        for (int i = 2; i < N + 1; i++) {
            // 직전과 비교
            // 더 크면 이전에서 +1
            // 더 작으면 앞에 원소랑 하나씩 비교하여 이어 붙인다.

            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[0][i] < dp[0][j] + 1) {
                        dp[0][i] = dp[0][j] + 1;
                        dp[1][i] = j;
                    }
                }
            }
        }

        int max_length = Integer.MIN_VALUE;
        int max_index = 0;

        for (int i = 1; i < N + 1; i++) {
            if (dp[0][i] > max_length) {
                max_length = dp[0][i];
                max_index = i;
            }
        }

        sb.append(max_length).append("\n");

        int[] result = new int[max_length];

        for (int i = 0; i < max_length; i++) {
            result[max_length - i - 1] = arr[max_index];
            max_index = dp[1][max_index];
        }

        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}