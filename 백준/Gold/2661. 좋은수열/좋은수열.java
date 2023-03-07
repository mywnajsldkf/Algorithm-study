import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb;
    static String result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        result = "";

        findSequence(result);
    }

    // 수열을 만든다.
    private static void findSequence(String sequence) {
        if (sequence.length() == N) {
            System.out.println(sequence);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            if (isGood(sequence + i)) {
                findSequence(sequence + i);
            }
        }
    }

    private static boolean isGood(String sequence) {
        for (int i = 1; i <= sequence.length() / 2; i++) {
            String front = sequence.substring(sequence.length() - i * 2, sequence.length() - i);
            String back = sequence.substring(sequence.length() - i, sequence.length());
            if (front.equals(back)) {
                return false;
            }
        }
        return true;
    }
}