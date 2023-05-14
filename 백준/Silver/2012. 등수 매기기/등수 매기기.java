import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] expected_grade;
    static long sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        expected_grade = new int[N];

        for (int i = 0; i < N; i++) {
            expected_grade[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(expected_grade);
        
        for (int i = 0; i < N; i++) {
            // 실제 등수와 예상 등수가 같다.
            if (i + 1 == expected_grade[i]) {
                sum += 0;
            } else {
                sum += Math.abs(expected_grade[i] - (i + 1));
            }
        }

        sb.append(sum);
        System.out.println(sb);
    }
}