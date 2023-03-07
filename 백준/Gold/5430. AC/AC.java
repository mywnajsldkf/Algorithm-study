import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static String p;
    static int n;
    // static List<Integer> array;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> deque;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            // array = new LinkedList<>();
            deque = new ArrayDeque<Integer>();
            p = br.readLine();
            n = Integer.parseInt(br.readLine());
            String stringArray = br.readLine();
            stringArray = stringArray.replace("[", "");
            stringArray = stringArray.replace("]", "");
            StringTokenizer st = new StringTokenizer(stringArray, ",");
            for (int j = 0; j < n; j++) {
                // array.add(Integer.parseInt(st.nextToken()));
                deque.add(Integer.parseInt(st.nextToken()));
            }
            // AC(p, array);
            AC(p, deque);
        }
        System.out.println(sb);
        // bw.flush();
    }

    private static void AC(String p, ArrayDeque<Integer> numbers) throws IOException {
        boolean isRight = true;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == 'R') {
                isRight = !isRight;
                continue;
                // Collections.reverse(numbers);
            }
            if (isRight) {
                if (numbers.pollFirst() == null) {
                    sb.append("error\n");
                    // bw.write("error\n");
                    return;
                }
            } else {
                if (numbers.pollLast() == null) {
                    sb.append("error\n");
                    // bw.write("error\n");
                    return;
                }
            }

            /*
            else if (p.charAt(i) == 'D' && numbers.size() == 0) {
                bw.write("error\n");
                // System.out.println("error");
                return;
            } else if (p.charAt(i) == 'D' && numbers.size() != 0) {
                numbers.remove(0);
            }
             */
        }

        // bw.write('[');
        sb.append("[");

        // 출력할 원소가 한 개 이상일 경우
        if (numbers.size() > 0) {
            if (isRight) {
                sb.append(numbers.pollFirst());
                while (!numbers.isEmpty()) {
                    sb.append(',').append(numbers.pollFirst());
                }
            } else {
                sb.append(numbers.pollLast());
                while (!numbers.isEmpty()) {
                    sb.append(',').append(numbers.pollLast());
                }
            }
        }

        /*
        while (numbers.size() != 1) {
            if (isRight) {
                bw.write(String.valueOf(numbers.pollFirst()));
                bw.write(',');
            } else {
                bw.write(String.valueOf(numbers.pollLast()));
                bw.write(',');
            }
        }

        if (numbers.size() != 0) {
            // bw.write(String.valueOf(numbers.poll()));
            sb.append(numbers.poll());
        }
         */

        /*
        for (int i = 0; i < numbers.size() - 1; i++) {


            bw.write(String.valueOf(numbers.get(i)));
            bw.write(",");

            // sb.append(numbers.get(i));
            // sb.append(",");
        }
        if (numbers.size() != 0) {
            bw.write(String.valueOf(numbers.get(numbers.size() - 1)));
            // sb.append(numbers.get(numbers.size() - 1));
        }

         */
        // bw.write("]\n");
        sb.append(']').append('\n');
    }
}