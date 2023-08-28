import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T, M, N, x, y;
    static int m_x, m_y;
    static String arr[];
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            arr = br.readLine().split(" ");
            M = Integer.parseInt(arr[0]);
            N = Integer.parseInt(arr[1]);
            x = Integer.parseInt(arr[2]);
            y = Integer.parseInt(arr[3]);

            sb.append(calendar(M, N, x, y)).append("\n");
        }

        System.out.println(sb);
    }

    static int calendar(int M, int N, int x, int y) {
        while (x <= M * N) {
            if ((x - y) % N == 0) {
                return x;
            }
            x += M;
        }
        return -1;
    }
}
