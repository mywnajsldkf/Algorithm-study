import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] students;
    // static int[] visited;
    static boolean[] visited;
    static boolean[] finished;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            students = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];

            count = 0;

            // visited = new int[N + 1]; -> 0, 1, 2 다르게 할까했지만 생각해보니 int 4바이트/boolean 1바이트임
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                students[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= N; j++) {
                if (!finished[j]) {
                    DFS(j);
                }
            }
            sb.append(N - count).append("\n");
        }
        System.out.println(sb);
    }

    private static void DFS(int now) {
        // 이미 방문한 경우
        if (visited[now]) {
            finished[now] = true;   // 팀 편성 완료 -> 더 이상 볼 필요 없음
            count++;
        }
        // 방문안한 경우 -> 탐색에서 방문하면 안되니까
        else {
            visited[now] = true;
        }
        // 다음 학생이 팀 결성을 아직 못했다면 -> 탐색
        if (!finished[students[now]]) {
            DFS(students[now]);
        }
        visited[now] = false;   // 팀 편성 실패
        finished[now] = true;   // 이 다음 방문에서 확인
    }
}