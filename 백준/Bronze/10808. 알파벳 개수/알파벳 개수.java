import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] alphabet = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - '0' - 49] += 1;
//            System.out.println(s.charAt(i) - '0' - 49);
        }

        for (int i = 0; i < 26; i++) {
            sb.append(alphabet[i]).append(" ");
        }

        System.out.println(sb);
    }
}
