import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char S[];
    static int count;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine().toCharArray();

        count = 0;
        result = 0;

        for (int i = 1; i < M - 1; i++) {
            if (S[i - 1] == 'I' && S[i] == 'O' && S[i + 1] == 'I') {
                count++;
                if (count == N) {
                    count -= 1;
                    result++;
                }
                i++;
            } else {
                count = 0;
            }
        }
        sb.append(result);
        System.out.println(sb);
    }
}
