import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> stackList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if (order.equals("push")) {
                stackList.add(Integer.parseInt(st.nextToken()));
            } else if (order.equals("top")) {
                if (stackList.isEmpty()) {
                    System.out.println(-1);
                }else {
                    System.out.println(stackList.get(stackList.size() - 1));
                }
            } else if (order.equals("size")) {
                System.out.println(stackList.size());
            } else if (order.equals("empty")) {
                if (stackList.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (order.equals("pop")) {
                if (stackList.isEmpty()) {
                    System.out.println(-1);
                }else {
                    System.out.println(stackList.get(stackList.size() - 1));
                    stackList.remove(stackList.size() - 1);
                }
            }
        }
    }
}