import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PrivateKey;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] bowl;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 어항의 수
        K = Integer.parseInt(st.nextToken());   // 물고리 수의 차이(최소, 최대)

        bowl = new int[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());
        // 초기화
        for (int i = 0; i < N; i++) {
            bowl[0][i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        while (!isSuccess()) {
            blockProcess();
            count += 1;
        }

        System.out.println(count);
    }

    private static boolean isSuccess() {
        int subtraction = findBiggest() - findSmallest();
        return subtraction <= K;
    }

    private static void blockProcess() {
        addFish();
        rotateBlocks();
        adjustBlocks();
        arrangeBlocks();
        foldBlocks();
        adjustBlocks();
        arrangeBlocks();
    }

    // N/2개를 공중 부양시켜 시계 방향으로 180도 회전 시킨 다음, 오른쪽 N/2개의 위에 놓는다.
    // 한번 더 바복하여 N/2를 공중 부양시켜 시계 방향으로 180도 회전 시킨 다음, 오른쪽 N/2개의 위에 놓는다.
    private static void foldBlocks() {
        for (int i = 0; i < N / 4; i++) {
            bowl[1][N - 1 - i] = bowl[0][i];
            bowl[0][i] = 0;
        }

        for (int i = 0; i < N / 4; i++) {
            bowl[2][N / 4 * 3 + i] = bowl[0][N / 4 + i];
            bowl[0][N / 4 + i] = 0;
        }

        for (int i = 0; i < N / 4; i++) {
            bowl[3][N - 1 - i] = bowl[0][N / 2 + i];
            bowl[0][N / 2 + i] = 0;
        }
    }

    // Block을 다시 일열로 만든다.
    private static void arrangeBlocks() {
        int[] temp = new int[N];
        int idx = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (bowl[y][x] != 0) {
                    temp[idx++] = bowl[y][x];
                    bowl[y][x] = 0;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            bowl[0][i] = temp[i];
        }
    }

    private static void adjustBlocks() {
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                calcDiff(temp, i, j, i + 1, j); // 아래 확인
                calcDiff(temp, i, j, i, j + 1); // 오른쪽 확인
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bowl[i][j] += temp[i][j];   // temp 배열에 있는 것을 대입
            }
        }

    }

    private static void calcDiff(int[][] temp, int y1, int x1, int y2, int x2) {
        // 비어있으면 아무것도 안한다.
        if (bowl[y1][x1] == 0) return;
        if (bowl[y2][x2] == 0) return;

        int value = Math.abs(bowl[y1][x1] - bowl[y2][x2]) / 5;
        if (bowl[y1][x1] > bowl[y2][x2]) {
            temp[y1][x1] -= value;
            temp[y2][x2] += value;
        } else {
            temp[y1][x1] += value;
            temp[y2][x2] -= value;
        }
    }

    // 2. 회전시킨다. https://jangcenter.tistory.com/94 -> 그림으로 그려본다.
    private static void rotateBlocks() {
        int width = 1, height = 1, start = 1;   // start: N줄의 처음 시작 위치(pivot)
        int index = 0;  // 가로로 늘릴지, 세로로 늘릴지

        while (start + height - 1 < N) {
            index += 1;
            for (int y = 0; y < height; y++) {
                for (int x = start - width; x < start; x++) {
                    bowl[start - x][start + y] = bowl[y][x];
                    bowl[y][x] = 0;
                }
            }
            start += height;

            if (index % 2 == 0) width += 1;
            else height += 1;
        }
    }

    // 물고리를 집어 넣는다.
    private static void addFish() {
        int min = findSmallest();
        for (int i = 0; i < N; i++) {
            if (bowl[0][i] == min) {
                bowl[0][i]++;
            }
        }
    }

    // 가장 작은 물고기 찾기
    private static int findSmallest() {
        int smallest = bowl[0][0];
        for (int i = 0; i < N; i++) {
            if (smallest > bowl[0][i]) {
                smallest = bowl[0][i];
            }
        }
        return smallest;
    }

    // 가장 큰 물고기 찾기
    private static int findBiggest() {
        int biggest = bowl[0][0];
        for (int i = 0; i < N; i++) {
            if (biggest < bowl[0][i]) {
                biggest = bowl[0][i];
            }
        }
        return biggest;
    }

}