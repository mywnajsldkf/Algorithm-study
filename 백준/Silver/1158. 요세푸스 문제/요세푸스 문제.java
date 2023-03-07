import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int start = 0;   // 시작 위치
    static int value = 0;   // 현재 위치
    static Queue<Integer> circle = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            circle.offer(i);
        }

        sb.append('<');

        while (circle.size() != 1) {
            for (int i = 0; i < K - 1; i++) {
                circle.offer(circle.poll());
            }
            sb.append(circle.poll() + ", ");
        }
        sb.append(circle.poll() + ">");

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}