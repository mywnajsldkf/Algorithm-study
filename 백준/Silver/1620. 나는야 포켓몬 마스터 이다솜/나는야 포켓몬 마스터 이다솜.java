import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static String[] names;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nameMap = new HashMap<>();
        names = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameMap.put(name, i);
            names[i] = name;
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();

            // 숫자면
            if (isNumber(input)) {
                sb.append(names[Integer.parseInt(input)]).append("\n");
            } else {
                sb.append(nameMap.get(input)).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}