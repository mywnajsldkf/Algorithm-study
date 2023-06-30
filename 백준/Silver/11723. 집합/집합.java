import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M;
    static Set<Integer> S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(br.readLine());
        S = new HashSet<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                if (S.contains(x)) {
                    continue;
                } else {
                    S.add(x);
                }
            } else if (command.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                S.remove(x);
            } else if (command.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                if (S.contains(x)) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else if (command.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                if (S.contains(x)) {
                    S.remove(x);
                } else {
                    S.add(x);
                }
            } else if (command.equals("all")) {
                S.clear();
                for (int number = 1; number <= 20; number++) {
                    S.add(number);
                }
            } else if (command.equals("empty")) {
                S.clear();
            }
        }

        System.out.println(sb);
    }
}