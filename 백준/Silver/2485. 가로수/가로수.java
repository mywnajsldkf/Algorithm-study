import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] trees;
    static int[] intervals;
    static int gcd;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        trees = new int[N];
        intervals = new int[N-1];
        sum = 0;

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N - 1; i++) {
            intervals[i] = trees[i + 1] - trees[i];
        }
        gcd = findGCD(intervals);

        for (int i = 0; i < intervals.length; i++) {
            sum += (intervals[i] / gcd - 1);
        }
        System.out.println(sum);
    }

    private static int findGCD(int[] arr) {
        int answer = 0;

        if (arr.length == 1) {
            return arr[0];
        }

        int gcd = gcd(arr[0], arr[1]);
        answer = gcd;

        if (arr.length > 2) {
            for (int i = 2; i < arr.length; i++) {
                answer = gcd(answer, arr[i]);
            }
        }

        return answer;
    }

    private static int gcd(int a, int b) {
        int r = a % b;
        if (r == 0) {
            return b;
        } else return gcd(b, r);
    }
}