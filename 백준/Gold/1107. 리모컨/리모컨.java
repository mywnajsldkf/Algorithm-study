import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] broken = new boolean[10];  // 0~9

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());    // 이동하려고 하는 채널 번호
        M = Integer.parseInt(br.readLine());    // 고장난 버튼의 개수

        if (M > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;    // broken 표시한다.
            }
        }

        int result = Math.abs(N - 100); // 초기값 -> 최악의 경우에 (+,-) 버튼만으로 도달해야한다.

        for (int i = 0; i <= 999999; i++) {
            int now = i;    // 확인해야하는 번호, 자릿수로 있는지 확인해야 한다.
            int len = possible(now);

            if (len > 0) {
                int press = Math.abs(now - N);  // n: 이동 원하는 채널
                if (result > len + press) {
                    result = len + press;
                }
            }
        }
        System.out.println(result);
   }

    private static int possible(int now) {
        // 확인하려고하는 값이 0이라면 -> 예외처리해줘야한다.
        if (now == 0) {
            // 숫자 0이 고장났다면, 0을 검색해서 갈 수 없음
            if (broken[0]) {
                return 0;
            } else {    // 고장나지 않았다면 0을 검색해서 갈 수 있음
                return 1;
            }
        }

        int len = 0;
        while (now > 0) {
            // 자릿수로 확인한다.
            if (broken[now % 10]) { // 고장난 자릿수라면
                return 0;
            }
            len += 1;   // 한번 입력
            now /= 10;
        }
        return len;
    }
}
