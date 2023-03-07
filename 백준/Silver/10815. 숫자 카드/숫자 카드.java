import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<Integer> inputList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            inputList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(inputList);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(Integer.parseInt(st.nextToken()))).append(' ');
        }

        System.out.println(sb);

    }

    private static int binarySearch(int key) {
        // 탐색 범위의 왼쪽 끝 인덱스
        int left = 0;
        // 탐색 범위의 오른쪽 끝 인덱스
        int right = inputList.size() - 1;

        // left가 right보다 커지기 전까지 반복한다.
        while (left <= right) {
            int mid = (left + right) / 2;

            if (key < inputList.get(mid)) {
                right = mid - 1;
            } else if (key > inputList.get(mid)) {
                left = mid + 1;
            } else if (key == inputList.get(mid)) {
                return 1;
            }
        }

        return 0;
    }
}