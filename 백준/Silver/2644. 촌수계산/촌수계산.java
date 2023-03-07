import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int a, b;
    static boolean[][] family;
    static boolean[] visitied;
    static int count;
    static Queue<Integer> queue;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer str;

        int count = 0;

        n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        // 계산해야하는 촌수
        str = new StringTokenizer(br.readLine());
        a = Integer.parseInt(str.nextToken());
        b = Integer.parseInt(str.nextToken());

        m = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        family = new boolean[n + 1][n + 1];
        visitied = new boolean[n + 1];
        nums = new int[n + 1];

        for (int i = 0; i < m; i++) {
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            family[a][b] = true;
            family[b][a] = true;
        }

        queue = new LinkedList<>();

        queue.add(a);
        visitied[a] = true;

        while (!queue.isEmpty()) {
            int willVisit = queue.poll();

            if (willVisit == b) {
                break;
            }

            for (int i = 1; i <= n; i++) {
                if (!visitied[i] && family[willVisit][i]) {
                    queue.add(i);
                    visitied[i] = true;
                    nums[i] = nums[willVisit] + 1;
                }
            }
        }

        if (nums[b] == 0) {
            sb.append(-1);
        } else {
            sb.append(nums[b]);
        }

        System.out.println(sb);
    }
}
