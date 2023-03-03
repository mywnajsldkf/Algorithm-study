import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean numbers[];
    static int N;
    static int answerCount;
    static List<Integer> primes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new boolean[4000001];
        primes = new ArrayList<>();

        makePrime();

        answerCount = 0;

        for (int i = 0; i < primes.size(); i++) {
            int total = 0;
            int start = i;

            while (total <= N && start < primes.size()) {
                total += primes.get(start);
                start++;

                if (total == N) {
                    answerCount++;
                    break;
                }
            }
        }
        System.out.println(answerCount);
    }

    private static void makePrime() {
        for (int i = 0; i <= 4000000; i++) {
            numbers[i] = true;
        }

        for (int i = 2; i <= N; i++) {
            if (numbers[i] == false) {
                continue;
            }

            primes.add(i);
            for (int j = 2 * i; j <= N; j += i) {
                numbers[j] = false;
            }
        }
    }
}