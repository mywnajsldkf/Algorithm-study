import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int MAX = Integer.MIN_VALUE;  // integer의 최소,최대 출력 가능
    public static int MIN = Integer.MAX_VALUE;
    public static int[] operator = new int[4];  // 연산자 개수
    public static int[] number; // 숫자
    public static int N;    // 숫자 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        number = new int[N];

        st = new StringTokenizer(br.readLine());

        // 숫자 입력
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(number[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);

    }

    // depth, idx
    public static void dfs(int num, int depth) {
        if (depth == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                switch (i) {
                    case 0:
                        dfs(num + number[depth], depth + 1);
                        break;
                    case 1:
                        dfs(num - number[depth], depth + 1);
                        break;
                    case 2:
                        dfs(num * number[depth], depth + 1);
                        break;
                    case 3:
                        dfs(num / number[depth], depth + 1);
                        break;
                }
                // 재귀호출 종료 -> 다시 연산자 개수 복구
                operator[i]++;
            }
        }
    }

}