import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static String[] N;
    static int[] numbers;
    static int index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = br.readLine().split("");

        numbers = new int[10];

        for (int i = 0; i < N.length; i++) {
            index = Integer.parseInt(N[i]);
            if (index == 9) {
                index = 6;
            }
            numbers[index] += 1;
        }

        if (numbers[6] % 2 == 1) {
            numbers[6] = numbers[6] / 2 + 1;
        } else {
            numbers[6] /= 2;
        }

        int max = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        sb.append(max);
        System.out.println(sb);
    }
}