import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(moveZ(N, r, c));
    }

    private static int moveZ(int n, int r, int c) {
        if (n < 1) {
            return 0;
        }

        int mid = (int) Math.pow(2, n - 1);

        // 경계를 잘 살피자!!!!
        if (r < mid && c < mid) {
            return moveZ(n - 1, r, c);
        } else if (r < mid && c >= mid) {
            return mid * mid + moveZ(n - 1, r, c - mid);
        } else if (r >= mid && c < mid) {
            return 2 * mid * mid + moveZ(n - 1, r - mid, c);
        }
        return 3 * mid * mid + moveZ(n - 1, r - mid, c - mid);
    }
}