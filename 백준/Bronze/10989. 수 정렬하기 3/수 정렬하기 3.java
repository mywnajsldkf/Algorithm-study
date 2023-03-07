import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int[] resultArray = new int[10000000];     // 정렬될 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 수의 범위 (0~10001)
        int[] cnt = new int[10001];

        // 초기화
        for (int i = 0; i < N; i++) {
            cnt[Integer.parseInt(br.readLine())] ++;
        }

        br.close();

        StringBuilder sb = new StringBuilder();

        // 0은 입력범위에서 없으므로 1부터 시작한다.
        for (int i = 1; i < 10001; i++) {
            // i 값이 개수가 0이 될때까지 출력한다.
            while (cnt[i] > 0) {
                sb.append(i).append("\n");
                cnt[i]--;
            }
        }
        System.out.println(sb);
    }
}