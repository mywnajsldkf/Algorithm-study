import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static String S;
    static String P ="";
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();

        for (int i = 0; i < N; i++) {
            P += "IO";
        }
        P += "I";

        for (int i = 0; i <= M - P.length(); i++) {
            String temp = "";
            for (int j = i; j < i + P.length(); j++) {
                temp += S.charAt(j);
                if (S.charAt(j) != P.charAt(j - i)) {
                    break;
                }
            }
            if (temp.equals(P)) {
                count += 1;
            }
        }
        sb.append(count);
        System.out.println(sb);
    }
}
