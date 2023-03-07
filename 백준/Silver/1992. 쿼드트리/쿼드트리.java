import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        quadTree(0, 0, N);

        System.out.print(sb);

    }

    private static void quadTree(int y, int x, int size) {
        if (isPossible(y, x, size)) {
            sb.append(map[y][x]);
            return;
        }

        int newSize = size / 2;
        sb.append("(");
        quadTree(y, x, newSize);
        quadTree(y, x+newSize, newSize);
        quadTree(y + newSize, x, newSize);
        quadTree(y + newSize, x + newSize, newSize);
        sb.append(")");
    }

    private static boolean isPossible(int y, int x, int size) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[y][x] != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
