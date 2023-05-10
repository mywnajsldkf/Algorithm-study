import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] money;
    static int goal;
    static int middle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        money = new int[n];

        st = new StringTokenizer(br.readLine());
        int min = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(st.nextToken());

            if (money[i] < min) {
                min = money[i];
            }
            if (money[i] >= max) {
                max = money[i];
            }
        }

        goal = Integer.parseInt(br.readLine());
        int sum;

        while (min <= max) {
            middle = (min + max) / 2;
            // System.out.println("max = " + max);
            // System.out.println("min = " + min);
            // System.out.println("middle = " + middle);
            sum = 0;

            for (int i = 0; i < n; i++) {
                if (money[i] <= middle) {
                    sum += money[i];
                } else {
                    sum += middle;
                }
            }
            // System.out.println("sum = " + sum);

            // 같으면 -> continue
            if (sum <= goal) {
                min = middle + 1;
            }

            //
            else {
                max = middle - 1;
            }
        }

        sb.append(max);

        System.out.println(sb);
    }

}
