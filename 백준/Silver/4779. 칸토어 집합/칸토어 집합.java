import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int dp[];
    static char[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            try {
                n = (int) Math.pow(3, Integer.parseInt(br.readLine()));
                result = new char[n];

                // 공백 받아두고 시작
                for (int i = 0; i < result.length; i++) {
                    result[i] = ' ';
                }
                makeArray(0, n - 1, result.length);
                sb.append(result).append("\n");
            } catch (NumberFormatException exception) {
                break;
            }
        }
        System.out.println(sb);
    }

    private static void makeArray(int first, int last, int size) {
        if (size == 1) {
            result[first] = '-';
        } else {
            // n을 3으로 나누어서 다시 시작한다.
            int tmp_size = size / 3;
            makeArray(first, first + tmp_size - 1, tmp_size);
            // makeBlank(n);
            makeArray(last - tmp_size + 1, last, tmp_size);
        }
    }
}