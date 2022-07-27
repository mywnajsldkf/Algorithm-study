package Algorithm.P2751;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2751 {
    static int N;
    static List<Integer> inputList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Algorithm/P2751/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            inputList.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(inputList);

        for (int i = 0; i < N; i++) {
            sb.append(inputList.get(i)).append('\n');
        }
        System.out.println(sb);
    }
}
