import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    static int N;
    static TreeSet<Integer> numbers = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 길이

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        Iterator<Integer> iter = numbers.iterator();

        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }
}