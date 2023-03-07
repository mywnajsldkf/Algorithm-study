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

        List<Integer> queueList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if (order.equals("push")) {
                queueList.add(Integer.parseInt(st.nextToken()));
            } else if (order.equals("pop")) {
                if (queueList.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queueList.get(0));
                    queueList.remove(0);
                }
            } else if (order.equals("size")) {
                System.out.println(queueList.size());
            } else if (order.equals("empty")) {
                if (queueList.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (order.equals("front")) {
                if (queueList.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queueList.get(0));
                }
            } else if (order.equals("back")) {
                if (queueList.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queueList.get(queueList.size() - 1));
                }
            }
        }
    }
}