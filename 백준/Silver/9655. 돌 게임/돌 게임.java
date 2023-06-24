import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        int i = 1;

        // 3개 또는 1개를 가져갈 수 있음 -> 3개부터 채우기 시작한다.
        while (n > 0) {
            if (n > 3) {
                n -= 3;     // n에 3빼고 업데이트
                i++;
            } else {
                n -= 1;
                i++;
            }
        }

        // 짝수면 -> 창영
        if ((i-1) % 2 == 0) {
            sb.append("CY");
        } else {
            sb.append("SK");
        }

        System.out.println(sb);
    }
}
