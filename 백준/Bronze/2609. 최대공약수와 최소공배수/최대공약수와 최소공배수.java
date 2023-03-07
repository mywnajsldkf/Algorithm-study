import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringTokenizer st;
    static StringBuilder sb;
    static int gcd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        gcd = findGCD(N, M);
        sb.append(gcd);
        sb.append("\n");
        sb.append(findLCM(M, N));

        System.out.println(sb);
    }

    // 최대 공배수 구하기
    private static int findLCM(int n, int m) {
        return n * m / gcd;
    }

    // 최대 공약수 구하기
    private static int findGCD(int n, int m) {
        if (n % m == 0) {
            return m;
        }
        return findGCD(m, n % m);
    }


}
