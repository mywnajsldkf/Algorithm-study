import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int x, y;
    static int one, two, three, four, axis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            if (x == 0 || y == 0) {
                axis++;
            } else if (x > 0 && y > 0) {
                one++;
            } else if (x < 0 && y > 0) {
                two++;
            } else if (x < 0 && y < 0) {
                three++;
            } else {
                four++;
            }
        }

        sb.append("Q1: " + one).append("\n");
        sb.append("Q2: " + two).append("\n");
        sb.append("Q3: " + three).append("\n");
        sb.append("Q4: " + four).append("\n");
        sb.append("AXIS: " + axis).append("\n");

        System.out.println(sb);
    }
}