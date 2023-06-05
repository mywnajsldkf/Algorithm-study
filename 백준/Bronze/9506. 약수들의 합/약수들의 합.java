import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static StringBuilder sb;
    static int sum;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == -1) {
                break;
            }
            sum = 1;
            result = new ArrayList<>(1);

            for (int i = 2; i <= N / 2; i++) {
                if (N % i == 0) {
                    sum += i;
                    result.add(i);
                }
            }

            // 완전수이다.
            if (sum == N) {
                sb.append(N).append(" = ");
                sb.append("1").append(" + ");
                for (int i = 0; i < result.size() - 1; i++) {
                    sb.append(result.get(i)).append(" + ");
                }
                sb.append(result.get(result.size() - 1));
            } else {
                sb.append(N).append(" is NOT perfect.");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}