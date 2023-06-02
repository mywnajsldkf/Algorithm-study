import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] chess;
    static int count = Integer.MAX_VALUE;
    static int N, M;
    static String line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 8
        M = Integer.parseInt(st.nextToken());   // 8

        chess = new int[N][M];

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'W') {
                    chess[i][j] = 1;
                } else {
                    chess[i][j] = -1;
                }
            }
        }

        // 체스판 나누기 8*8로
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                count = Math.min(count, draw(i, j));
            }
        }

        sb.append(count);
        System.out.println(sb);
    }

    private static int draw(int y, int x) {
        int end_y = y + 8;
        int end_x = x + 8;
        int count = 0;

        int color = chess[y][x];

        for (int i = y; i < end_y; i++) {
            for (int j = x; j < end_x; j++) {
                if (chess[i][j] != color) {
                    count++;
                }
                color = -color;
            }
            color = -color;
        }

        count = Math.min(count, 64 - count);
        return count;
    }
}
