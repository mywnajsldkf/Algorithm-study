import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[] S;
    static boolean akaraka = true;
    static int middle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        S = br.readLine().split("");

        middle = (S.length - 1) / 2;
        isPelindrome(0, S.length - 1, middle);

        if (akaraka) {
            sb.append("AKARAKA");
        } else {
            sb.append("IPSELENTI");
        }
        System.out.println(sb);
    }

    private static void isPelindrome(int start, int end, int middle) {
        // 원소가 3개 이하이면
        if (end - start < 3) {
            if (!S[end].equals(S[start])) {
                akaraka = false;
                return;
            } else {
                if (end <= middle) {
                    for (int i = start; i <= end; i++) {
                        if (!S[i].equals(S[S.length - 1 - i])) {
                            akaraka = false;
                            return;
                        }
                    }
                }
            }
            return;
        }

        int m = (start + end) / 2;
        // 짝수인 경우
        if ((start + end) % 2 == 1) {
            isPelindrome(start, m, middle);
            isPelindrome(m + 1, end, middle);
        }
        // 홀수인 경우
        else {
            isPelindrome(start, m - 1, middle);
            isPelindrome(m + 1, end, middle);
        }
    }
}
