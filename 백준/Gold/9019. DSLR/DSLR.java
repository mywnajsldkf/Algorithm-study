import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T;
    static int A, B;
    static String fResult;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] str = br.readLine().split(" ");
            A = Integer.parseInt(str[0]);
            B = Integer.parseInt(str[1]);

            boolean[] visit = new boolean[10000];
            visit[A] = true;
            Queue<Register> queue = new LinkedList<>();
            queue.add(new Register(A, ""));

            String ans = "";

            while (!queue.isEmpty()) {
                Register cur = queue.poll();

                if (cur.num == B) {
                    sb.append(cur.command).append("\n");
                    break;
                }
                if (!visit[cur.D()]) {
                    queue.add(new Register(cur.D(), cur.command + "D"));
                    visit[cur.D()] = true;
                }
                if (!visit[cur.S()]) {
                    queue.add(new Register(cur.S(), cur.command + "S"));
                    visit[cur.S()] = true;
                }
                if (!visit[cur.L()]) {
                    queue.add(new Register(cur.L(), cur.command + "L"));
                    visit[cur.L()] = true;
                }
                if (!visit[cur.R()]) {
                    queue.add(new Register(cur.R(), cur.command + "R"));
                    visit[cur.R()] = true;
                }

            }
        }
        System.out.println(sb);
    }

}

class Register {
    int num;
    String command;

    public Register(int num, String command) {
        this.num = num;
        this.command = command;
    }

    int D() {
        return (num * 2) % 10000;
    }

    int S() {
        return num == 0 ? 9999 : num - 1;
    }

    int L() {
        return num % 1000 * 10 + num / 1000;
    }

    int R() {
        return num % 10 * 1000 + num / 10;
    }
}