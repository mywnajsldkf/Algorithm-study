import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int first, second;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());

            if (first == 0 && second == 0) {
                break;
            }

            if (second % first == 0) {
                sb.append("factor").append("\n");
            } else if (first % second == 0) {
                sb.append("multiple").append("\n");
            } else {
                sb.append("neither").append("\n");
            }
        }
        System.out.println(sb);
    }
}
