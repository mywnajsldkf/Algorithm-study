import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;
    static int value;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0, 0);
        sb.append(min);

        System.out.println(sb);
    }

    private static void combi(int a, int depth) {
        if (depth == N / 2) {
            diff();
            return;
        }

        for (int i = a; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                combi(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    private static void diff() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] == true && visit[j] == true) {
                    team_start += map[i][j];
                    team_start += map[j][i];
                } else if (visit[i] == false && visit[j] == false) {
                    team_link += map[i][j];
                    team_link += map[j][i];
                }
            }
        }

        value = Math.abs(team_start - team_link);

        if (value == 0) {
            sb.append(value);
            System.out.println(sb);
            System.exit(0);
        }
        min = Math.min(min, value);
    }
}