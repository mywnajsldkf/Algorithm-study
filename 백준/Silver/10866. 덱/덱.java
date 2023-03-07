import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> deque = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if (order.equals("push_front")) {
                deque.add(0, Integer.parseInt(st.nextToken()));
            } else if (order.equals("push_back")) {
                deque.add(Integer.parseInt(st.nextToken()));
            } else if (order.equals("pop_front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.get(0));
                    deque.remove(0);
                }
            } else if (order.equals("pop_back")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.get(deque.size() - 1));
                    deque.remove(deque.size() - 1);
                }
            } else if (order.equals("size")) {
                System.out.println(deque.size());
            } else if (order.equals("empty")) {
                if (deque.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (order.equals("front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.get(0));
                }
            } else if (order.equals("back")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.get(deque.size() - 1));
                }
            }
        }
    }
}