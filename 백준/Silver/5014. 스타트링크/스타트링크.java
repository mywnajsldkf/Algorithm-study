import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int F, S, G, U, D;
    static Queue<Integer> queue = new LinkedList<>();
    // static boolean[] visited;
    static int[] building;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        F = Integer.parseInt(st.nextToken());   // 건물 총 층
        S = Integer.parseInt(st.nextToken());   // 스타트링크가 있는 층
        G = Integer.parseInt(st.nextToken());   // 경호가 있는 층
        U = Integer.parseInt(st.nextToken());   // 위로 얼마나
        D = Integer.parseInt(st.nextToken());   // 아래로 얼마나

        //visited = new boolean[F + 1];
        dy = new int[2];
        building = new int[F + 1];

        dy[0] = U;
        dy[1] = -D;

        queue.add(S);
        building[S] = 1;

        if (S == G) {
            sb.append("0");
            System.out.println(sb);
            System.exit(0);
        }

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i = 0; i < 2; i++) {
                int temp_S = temp + dy[i];
                if (temp_S == G) {
                    // building[G] = building[temp] + 1;
                    sb.append(building[temp]);
                    System.out.println(sb);
                    System.exit(0);
                }
                else if (temp_S > F || temp_S < 1) {
                    continue;
                } else if (building[temp_S] == 0) {
                    queue.add(temp_S);
                    //visited[temp] = true;
                    building[temp_S] = building[temp] + 1;
                }
            }
        }
        sb.append("use the stairs");
        System.out.println(sb);
    }
}