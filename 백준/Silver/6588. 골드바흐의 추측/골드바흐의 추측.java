import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean play = true;
    static boolean[] numbers = new boolean[1000001];
    static List<Integer> primes = new ArrayList<>();
    static StringBuilder sb;
    static Integer n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        makePrime();

        while (play) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                play = false;
                System.out.println(sb);
                break;
            }
            // System.out.println("n = " + n);
            solveGoldbach(n);
        }
    }

    private static void solveGoldbach(Integer n) {
        // 8 = 3 + 5
        // 8 - 5 = 3
        for (int i = 0; i <= n; i++) {
            if (numbers[n - primes.get(i)]) {
                sb.append(n)
                        .append(" = ")
                        .append(primes.get(i))
                        .append(" + ")
                        .append(n - primes.get(i))
                        .append("\n");
                return;
            }
        }
        sb.append("Goldbach's conjecture is wrong.");
    }

    private static void makePrime() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = true;
        }
        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i] == false) {
                continue;
            }
            primes.add(i);
            for (int j = 2 * i; j < numbers.length; j += i) {
                numbers[j] = false;
            }
        }
    }
}