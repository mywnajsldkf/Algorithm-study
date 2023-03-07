import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int n_numbers[];
    static int numbers[];

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        n_numbers = new int[N + 1];
        numbers = new int[M + 1];

        for (int i = 0; i <= M; i++) {
            numbers[i] = i;
        }

        for (int i = 2; i <= M; i++) {
            if (numbers[i] == 0) {
                continue;
            }
            for (int j = 2 * i; j < M + 1; j += i) {
                numbers[j] = 0;
            }
        }

        for (int i = N; i <= M; i++) {
            if (numbers[i] == 1) {
                continue;
            }
            if (numbers[i] != 0) {
                sb.append(numbers[i]);
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}