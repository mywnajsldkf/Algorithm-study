import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int nA, nB;
    static Map<Integer, Integer> numbers = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        nA = Integer.parseInt(st.nextToken());
        nB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nA; i++) {
            numbers.put(Integer.parseInt(st.nextToken()), 0);
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nB; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (numbers.containsKey(now)) {
                numbers.remove(now);
            } else {
                numbers.put(now, 0);
            }
        }

        sb.append(numbers.size());
        System.out.println(sb);
   }
}