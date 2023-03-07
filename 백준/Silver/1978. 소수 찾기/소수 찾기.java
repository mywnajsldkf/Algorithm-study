import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] numbers;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());


        // 테스트 케이스
        N = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        count = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            count += findSosoo(numbers[i]);
        }

        sb.append(count);

        System.out.println(sb);
    }

    private static int findSosoo(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return 0;
            }
        }
        if (number == 1) {
            return 0;
        }

        return 1;
    }
}
