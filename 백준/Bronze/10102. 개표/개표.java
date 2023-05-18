import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int V;
    static String[] person;
    static int a = 0;
    static int b = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(br.readLine());
        person = br.readLine().split("");

        for (int i = 0; i <V; i++) {
            if (person[i].equals("A")) {
                a += 1;
            } else if (person[i].equals("B")) {
                b += 1;
            }
        }

        if (a > b) {
            sb.append("A");
        } else if (a < b) {
            sb.append("B");
        } else {
            sb.append("Tie");
        }

        System.out.println(sb);
    }
}
