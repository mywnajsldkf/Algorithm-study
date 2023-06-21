import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int money;
    static int count = 0;
//    static int[] rest = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        money = 1000 - Integer.parseInt(br.readLine());

        while (money > 0) {
            if (money >= 500) {
                money -= 500;
                count++;
            } else if (money >= 100 && money < 500) {
                money -= 100;
                count++;
            } else if (money >= 50 && money < 100) {
                money -= 50;
                count++;
            } else if (money >= 10 && money < 50) {
                money -= 10;
                count++;
            } else if (money >= 5 && money < 10) {
                money -= 5;
                count++;
            } else if (money >= 1 && money < 5) {
                money -= 1;
                count++;
            }
        }
        sb.append(count);
        System.out.println(sb);
    }
}
