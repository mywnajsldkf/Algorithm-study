import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int[] numbers = new int[1000001];
    static int n_N;
    static int temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            sb.append(0);
            System.out.println(sb);
            System.exit(0);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (true) {
            n_N = queue.poll();

            if (n_N % 3 == 0) {
                temp = n_N / 3;
                if (temp == 1) {
                    sb.append(numbers[n_N] + 1);
                    break;
                }
                if (numbers[temp] == 0) {
                    numbers[temp] = numbers[n_N] + 1;
                }
                queue.add(temp);
            }
            if (n_N % 2 == 0) {
                temp = n_N / 2;
                if (temp == 1) {
                    sb.append(numbers[n_N] + 1);
                    break;
                }
                if (numbers[temp] == 0) {
                    numbers[temp] = numbers[n_N] + 1;
                }
                queue.add(temp);
            }
            temp = n_N - 1;

            if (temp == 1) {
                sb.append(numbers[n_N] + 1);
                break;
            }
            if (numbers[temp] == 0) {
                numbers[temp] = numbers[n_N] + 1;
            }
            queue.add(temp);
        }

        System.out.println(sb);
    }
}