import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Stack<Integer> stack = new Stack();
    static int start = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());   // 자연수의 범위

        while (n != 0) {
            // 순서를 나타내는
            //System.out.println(br.readLine());
            int value = Integer. parseInt(br.readLine());
            if (value > start) {
                // start + 1 부터 입력받은 value까지 push
                for (int i = start + 1; i <= value; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                start = value;
            }
            // top에 있는 원소가 입력받은 값과 같지 않음
            else if (stack.peek() != value) {
                System.out.println("NO");
                return;
            }
            n--;
            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}