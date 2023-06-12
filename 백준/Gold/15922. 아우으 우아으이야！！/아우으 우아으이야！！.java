import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] line;
    static int sum = 0;
    static int start, last;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        line = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, ((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        }));

        start = line[0][0];
        last = line[0][1];

        for (int i = 1; i < N; i++) {
            // 업데이트한다.
            if (line[i][0] > last) {
                sum += (last - start);

                start = line[i][0];
                last = line[i][1];

            }

            if (line[i][0] <= last && line[i][1] > last) {
                last = line[i][1];
            }
        }

        sum += (last - start);

        sb.append(sum);
        System.out.println(sb);
    }
}