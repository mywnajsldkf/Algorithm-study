import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] height;
    static int[] subtract;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        height = new int[N];

        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        subtract = new int[N - 1];

        for (int i = 1; i < N; i++) {
            subtract[i - 1] = height[i] - height[i - 1];
        }

        Arrays.sort(subtract);

        int sum = 0;

        for (int i = 0; i < N - K; i++) {
            sum += subtract[i];
        }

        sb.append(sum);
        System.out.println(sb);
    }
}