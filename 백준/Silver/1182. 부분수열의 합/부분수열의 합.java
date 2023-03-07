import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] numbers;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 정수의 개수
        S = Integer.parseInt(st.nextToken());   // 정수

        numbers = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        findSubArray(0, 0);
        if (S == 0) {
            count--;
        }
        sb.append(count);
        System.out.println(sb);
    }

    private static void findSubArray(int start, int sum) {
        if (sum == S) {
            count++;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                findSubArray(i + 1, sum + numbers[i]);
                visited[i] = false;
            }
        }
    }
}