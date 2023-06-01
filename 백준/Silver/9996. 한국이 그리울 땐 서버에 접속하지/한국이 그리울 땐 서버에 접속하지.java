import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static String[] patterns;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        patterns = br.readLine().split("\\*");

        for (int i = 0; i < N; i++) {
            String sentence = br.readLine();

            if (isPattern(sentence)) {
                sb.append("DA").append("\n");
            } else {
                sb.append("NE").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean isPattern(String sentence) {
        // 겹치는지 아닌지 확인한다.
        if ((patterns[0].length() + patterns[1].length()) > sentence.length()) {
            return false;
        }

        // 첫번째 패턴이 같은지 확인
        for (int i = 0; i < patterns[0].length(); i++) {
            if (sentence.charAt(i) != patterns[0].charAt(i)) {
                return false;
            }
        }

        // 두번째 패턴이 같은지 확인
        for (int i = 0; i < patterns[1].length(); i++) {
            if (sentence.charAt(sentence.length() - 1 - i) != patterns[1].charAt(patterns[1].length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}