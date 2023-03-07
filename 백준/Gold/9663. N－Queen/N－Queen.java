import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[] arr;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 길이
        arr = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    private static void nQueen(int depth) {
        // 모든 원소를 다 채운 상태면 count를 증가하고 return한다.
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (togo(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    // 놓을 위치가 다른 퀸으로부터 위협받는가
    private static boolean togo(int col) {
        for (int i = 0; i < col; i++) {
            // 해당 열의 행과 i열의 행이 일치하는 경우(같은 행에 존재하는 경우)
            if (arr[col] == arr[i]) {
                return false;
            }
            // 대각선상에 놓인 경우
            // 열의 차와 행의 차가 같으면 대각선에 놓인 경우이다.
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}