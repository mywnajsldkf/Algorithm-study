import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987654321;
    static int N, M;
    static int[][] person;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 유저의 수
        M = Integer.parseInt(st.nextToken());   // 친구 관계의 수

        person = new int[N][N];

        // 초기값 설정
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                person[i][j] = INF;
                if (i == j) {
                    person[i][j] = 0;
                }
            }
        }

        // 친구 관계 수 -> 간선의 방향이 양방향이어야 한다.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            person[a - 1][b - 1] = 1;
            person[b - 1][a - 1] = 1;
        }

        // 플로이드 워샬 알고리즘 적용
        for (int k = 0; k < N; k++) {           // 거쳐가는 노드
            for (int i = 0; i < N; i++) {       // 출발 노드
                for (int j = 0; j < N; j++) {   // 도착 노드
                    person[i][j] = Math.min(person[i][j], person[i][k] + person[k][j]);
                }
            }
        }
        
        int result = Integer.MAX_VALUE;
        int r_index = 0;
        for (int i = 0; i < N; i++) {
            int total = 0;
            for (int j = 0; j < N; j++) {
                total += person[i][j];
            }
            if (result > total) {
                result = total;
                r_index = i;
            }
        }
        System.out.println(r_index + 1);
    }
}
