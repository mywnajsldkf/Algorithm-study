import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Character> PS = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String st = br.readLine();
            bw.write(isVPS(st));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static String isVPS(String ps) {
        Queue<Character> psQueue = new LinkedList<>();

        for (int i = 0; i < ps.length(); i++) {
            if (ps.charAt(i) == '(') {
                psQueue.add(ps.charAt(i));
            } else if (ps.charAt(i) == ')') {
                if (psQueue.isEmpty()) {
                    return "NO";
                }
                else psQueue.remove();
            }
        }

        if (psQueue.isEmpty()) {
            return "YES";
        } else return "NO";
    }
}