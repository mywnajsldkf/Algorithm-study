import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int r, e, c;
    static final String ADVERTISE = "advertise";
    static final String NOT_MATTER = "does not matter";
    static final String NOT_ADVERTISE = "do not advertise";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());   // 광고 안했을 때 수익
            e = Integer.parseInt(st.nextToken());   // 광고 했을 때 수익
            c = Integer.parseInt(st.nextToken());   // 광고 비용

            if (e - c > r) {
                sb.append(ADVERTISE).append("\n");
            } else if (e - c < r) {
                sb.append(NOT_ADVERTISE).append("\n");
            } else {
                sb.append(NOT_MATTER).append("\n");
            }
        }

        System.out.println(sb);
    }
}