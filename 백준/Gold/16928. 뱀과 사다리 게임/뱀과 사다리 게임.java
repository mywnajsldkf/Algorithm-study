import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, start, end, next;
    static int[] map;
    static int result = Integer.MAX_VALUE;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);   // 사다리의 수
        M = Integer.parseInt(str[1]);   // 뱀의 수

        map = new int[101];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            start = Integer.parseInt(str[0]);
            end = Integer.parseInt(str[1]);
            map[start] = end;
        }

        for (int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            start = Integer.parseInt(str[0]);
            end = Integer.parseInt(str[1]);
            map[start] = end;
        }

        queue.add(new int[]{1, 0}); // now, count

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int now_index = now[0];
            int count = now[1];
            map[now_index] = 101; // 방문 표시

            if (now_index == 100) {
                result = now[1];
                break;
            }

            for (int dice = 1; dice <= 6; dice++) {
                if ((now_index + dice) >= 101) {
                    continue;
                }
                int move = map[now_index + dice];
                if (move == 0) {
                    next = now_index + dice;
                } else {
                    next = move;
                }
                if (next >= 101) {
                    continue;
                }
                if (map[next] == 101) {
                    continue;
                }
                queue.add(new int[]{next, count + 1});
            }

        }
        sb.append(result);
        System.out.println(sb);
    }
}
