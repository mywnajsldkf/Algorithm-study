import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long hiddenNumber = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        String word = br.readLine();

        int tmp = 0;

        for (int i = 0; i < n; i++) {
            if (word.charAt(i) >= '0' && word.charAt(i) <= '9') {
                tmp = tmp * 10 + word.charAt(i) - '0';
            } else {
                hiddenNumber += tmp;
                tmp = 0;
            }
        }
        hiddenNumber += tmp;
        sb.append(hiddenNumber);
        System.out.println(sb);
    }
}
