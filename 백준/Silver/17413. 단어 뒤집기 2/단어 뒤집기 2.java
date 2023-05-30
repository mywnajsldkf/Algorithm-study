import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean isTag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();

        String S = br.readLine();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '<') {
                result.append(sb.reverse());
                sb = new StringBuilder();
                sb.append('<');
                isTag = true;
            } else if (S.charAt(i) == '>' && isTag) {
                sb.append('>');
                result.append(sb);
                sb = new StringBuilder();
                isTag = false;
            } else if (isTag) {
                sb.append(S.charAt(i));
            }
            // 공백이고, Tag로 감싸있는 것이 아니라면
            else if (S.charAt(i) == ' ' && !isTag) {
                result.append(sb.reverse());
                result.append(' ');
                sb = new StringBuilder();
            } else if (!isTag) {
                sb.append(S.charAt(i));
            }
        }
        result.append(sb.reverse());

        System.out.println(result);
    }
}