import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent = new int[1000001];  // 부모 집합을 생성한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 자연수의 범위
        M = Integer.parseInt(st.nextToken());   // 입력으로 주어지는 연산의 개수

        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (A == 0) {
                // B와 C를 합친다.
                union(B, C);
            }
            if (A == 1) {
                // B와 C가 같은 부모를 갖고 있는지 검사한다.
                // 같은 부모를 가진다면 -> YES
                // 다른 부모를 가진다면 -> NO
                int b = find(B);
                int c = find(C);

                if (b == c) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                } 
            }
        }

    }

    // 부모를 찾는다.
    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        else
            return parent[x] = find(parent[x]);
    }

    private static void union(int b, int c) {
        b = find(b);
        c = find(c);
        // 같은 부모를 가지고 있지 않다면 -> 부모를 같도록 해준다.
        if (b != c) {
            parent[c] = b;  // c가 c의 부모를 따라가도록 한다.
        }
    }
}