import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[][] computer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer str;

        int count = 0;

        // 컴퓨터 수
        N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        // 노드 수
        M = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        computer = new boolean[N + 1][N + 1];

        boolean[] visited = new boolean[N + 1];


        // 컴퓨터 초기화
        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            computer[a][b] = true;
            computer[b][a] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int start = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && computer[start][i]) {
                    queue.add(i);
                    visited[i] = true;
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
