import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] rope;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        rope = new int[n];

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            rope[i] = k;
        }

        Arrays.sort(rope);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, rope[i] * (n - i));
        }
        sb.append(max);
        System.out.println(sb);

    }
}