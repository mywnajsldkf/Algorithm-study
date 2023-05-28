import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String s;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb_result = new StringBuilder();
        s = br.readLine();

        result = 0;

        if (s.equals(new StringBuilder(s).reverse().toString())) {
            result = s.length();
            sb_result.append(result);
            System.out.println(sb_result);
            System.exit(0);
        }

        for (int i = 1; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);

            sb.append(new StringBuilder(s.substring(0, i)).reverse());
            if (sb.toString().equals(sb.reverse().toString())) {
                result = sb.length();
                break;
            }
        }

        sb_result.append(result);
        System.out.println(sb_result);
    }
}