import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        visited = new boolean[N + 1];

        comb(0);
    }

    private static void comb(int k) {
        // 출력
        if (k == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return; // 출력해버리기
        }

        for (int i = 1; i <= N; i++) {
            // 1부터 N까지
            if (!visited[i]) {
                arr[k] = i;
                visited[i] = true;
                comb(k + 1);
                visited[i] = false;
            }
        }
    }
}