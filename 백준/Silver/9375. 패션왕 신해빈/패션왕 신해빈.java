import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int t, n, result;
    static Map<String, Integer> clothes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            clothes = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String[] str = br.readLine().split(" ");
                int cnt = clothes.getOrDefault(str[1], 1);
                clothes.put(str[1], cnt + 1);
            }

            result = 1;

            for (int val : clothes.values()) {
                result *= val;
            }
            sb.append(result - 1).append("\n");
        }
        System.out.println(sb);
    }

}