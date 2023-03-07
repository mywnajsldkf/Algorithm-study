import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Integer n;
    // static List<Integer> numbers = new ArrayList<>();
    static StringBuilder sb;
    static int[] arr;
    static boolean[] visitied;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        arr = new int[6];

        while (true) {
            String testCase = br.readLine();
            if (testCase.equals("0")) {
                // System.out.println("종료");
                break;
            }
            // st = new StringTokenizer(br.readLine());
            st = new StringTokenizer(testCase);
            n = Integer.parseInt(st.nextToken());
            // System.out.println("n" + n);
            visitied = new boolean[n];
            numbers = new int[n];

            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            DFS(numbers, 0, 0);

            // System.out.println();
            sb.append("\n");
            // Integer zero = new Integer(0);
            /*
            if (n.equals(0)) {
                System.out.println("종료");
                break;
            }
             */
        }
        System.out.println(sb);
    }

    private static void DFS(int[] numbers, int start, int depth) {
        // 6개를 고르는 것이니, 6개가 채워지면 출력한다.
        if (depth == 6) {
            for (int i = 0; i < n; i++) {
                // sb.append(arr[i] + " ");
                // System.out.print(arr[i] + " ");
                if (visitied[i]) {
                    sb.append(numbers[i]).append(" ");
                    // System.out.print(numbers[i] + " ");
                }
            }
            sb.append("\n");
        }

        for (int i = start; i < n; i++) {
            if (!visitied[i]) {
                visitied[i] = true;
                DFS(numbers, i + 1, depth + 1);
                visitied[i] = false;
            }
        }
    }
}