import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] numbers;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        arr = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        dfs(0, 0);

        System.out.println(sb);
    }

    static void dfs(int start, int depth) {
        int before = 0;
        if (depth == M) {
            for (int number : arr) {
                sb.append(number + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            int now = numbers[i];

            if (now == before) {
                continue;
            }
            before = now;
            arr[depth] = now;
            dfs(i, depth + 1);
        }
    }
}
