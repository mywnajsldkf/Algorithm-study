import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static String[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new String[n][n];

        drawStar(n, 0, 0);

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == null) {
                    sb.append(" ");
                }else {
                    sb.append(arr[i][j]);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void drawStar(int n, int y, int x) {
        // 몫이 1이라면
        if (n == 3){
            arr[y][x] = "*";
            arr[y][x + 1] = "*";
            arr[y][x + 2]= "*";
            arr[y + 1][x] = "*";
            arr[y + 1][x + 1] = " ";
            arr[y + 1][x + 2] = "*";
            arr[y + 2][x] = "*";
            arr[y + 2][x + 1] = "*";
            arr[y + 2][x + 2]= "*";
        }
        else {
            drawStar(n / 3, y, x);
            drawStar(n / 3, y, x + n / 3);
            drawStar(n / 3, y, x + n / 3 * 2);
            drawStar(n / 3, y + n / 3, x);
            drawStar(n / 3, y + n / 3, x + n / 3 * 2);
            drawStar(n / 3, y + n / 3 * 2, x);
            drawStar(n / 3, y + n / 3 * 2, x + n / 3);
            drawStar(n / 3, y + n / 3 * 2, x + n / 3 * 2);
        }
    }
}