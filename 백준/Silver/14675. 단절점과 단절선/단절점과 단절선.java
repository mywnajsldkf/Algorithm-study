import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] graph;
    static List<int[]> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        edges = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            String[] numbers = br.readLine().split(" ");
            int y = Integer.parseInt(numbers[0]);
            int x = Integer.parseInt(numbers[1]);
            graph[y].add(x);
            graph[x].add(y);
            edges.add(new int[]{y, x});
        }

        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            String[] numbers = br.readLine().split(" ");

            int question = Integer.parseInt(numbers[0]);
            int k = Integer.parseInt(numbers[1]);

            if (question == 2) {
                sb.append("yes").append("\n");
            } else if (question == 1) {
                int count = 0;
                for (int temp : graph[k]) {
                    count++;
                }
                if (count >= 2) {
                    sb.append("yes").append("\n");
                } else sb.append("no").append("\n");
            }
        }

        System.out.println(sb);
    }
}