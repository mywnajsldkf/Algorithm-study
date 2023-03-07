import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static long MIN, MAX;
    static boolean[] numbers;
    static List<Long> modNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        MIN = Long.valueOf(st.nextToken());
        MAX = Long.valueOf(st.nextToken());
        numbers = new boolean[(int) (MAX - MIN + 1)];
        modNumbers = new ArrayList<>();

        for (long i = 2; i <= Math.sqrt(MAX); i++) {
            modNumbers.add(i * i);
        }

        for (int i = 0; i < modNumbers.size(); i++) {
            double t = (double) MIN / (double) modNumbers.get(i);
            long start = (long) ((modNumbers.get(i) * Math.ceil(t)) - MIN);

            for (long j = start; j < numbers.length; j += modNumbers.get(i)) {
                numbers[(int) j] = true;
            }
        }

        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (!numbers[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}