import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int MINIMUM_RESULT = Integer.MAX_VALUE;
    static int N;
    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 길이

        A = new int[N];
        B = new int[N];

        // A 초기화 -> A의 수를 재배열할 수 있고 B는 재배열할 수 없음
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // B 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += A[i] * B[N - 1 - i];
        }

        System.out.println(result);
    }
}