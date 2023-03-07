import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] A;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());   // 길이

        st = new StringTokenizer(br.readLine());

        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        if (N % 2 != 0) {
            result = A[N / 2] * A[N / 2];
        } else {
            for (int i = 0; i < N; i++) {
                result = A[0] * A[N - 1];
            }
        }

        sb.append(result);
        System.out.println(result);

    }
}