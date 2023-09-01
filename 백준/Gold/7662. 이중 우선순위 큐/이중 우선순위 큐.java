import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static int T, k;
    static TreeMap<Integer, Integer> treeMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            k = Integer.parseInt(br.readLine());
            treeMap = new TreeMap<>();
            for (int j = 0; j < k; j++) {
                String[] str = br.readLine().split(" ");
                String operation = str[0];
                int n = Integer.parseInt(str[1]);

                if (operation.equals("I")) {
                    treeMap.put(n, treeMap.getOrDefault(n, 0) + 1);
                } else {
                    // 사이즈가 0이면 continue
                    if (treeMap.size() == 0) {
                        continue;
                    }
                    int num;
                    if (str[1].equals("-1")) {          // 최솟값 삭제
                        num = treeMap.firstKey();
                    } else {    // 최댓값 삭제
                        num = treeMap.lastKey();
                    }
                    if (treeMap.put(num, treeMap.get(num) - 1) == 1) {
                        treeMap.remove(num);
                    }
                }
            }
            if (treeMap.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(treeMap.lastKey() + " " + treeMap.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}