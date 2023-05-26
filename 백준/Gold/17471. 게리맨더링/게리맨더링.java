import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] person;
    static List<ArrayList<Integer>> graph;
    static boolean[] selected;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        person = new int[N];
        result = Integer.MAX_VALUE;

        selected = new boolean[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            person[i] = Integer.parseInt(st.nextToken());
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            for (int j = 0; j < cnt; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()) - 1);
            }

            divide(0);
        }
        if (result == Integer.MAX_VALUE) {
            sb.append(-1);
        } else {
            sb.append(result);
        }

        System.out.println(sb);
    }

    private static void divide(int idx) {
        // 인구차 구한다.
        if (idx == N) {
            List<Integer> aArea = new ArrayList<>();
            List<Integer> bArea = new ArrayList<>();
            // 선택된 곳과 그렇지 않은 곳을 구분한다.

            for (int i = 0; i < N; i++) {
                if (selected[i]) {
                    aArea.add(i);
                } else {
                    bArea.add(i);
                }
            }

            // 한 지역에 쏠렸는지 확인한다.
            if (aArea.size() == 0 || bArea.size() == 0) {
                return;
            }

            // 모두 연결되었는지 확인한다.
            if (connect(aArea) && connect(bArea)) {

                getDiff();
                // 인구차를 구한다.
                return;
            }

            return;
        }
        // 선택 표시한다.
        selected[idx] = true;
        // depth를 1추가한다.
        divide(idx + 1);
        // 선택되지 않은 상태
        selected[idx] = false;
        divide(idx + 1);
    }

    public static boolean connect(List<Integer> list) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N];
        visited[list.get(0)] = true;
        queue.offer(list.get(0));

        int count = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);

                if (visited[next]) {
                    continue;
                }

                // 해당 선거구에 포함된다.
                if (list.contains(next)) {
                    queue.offer(next);
                    visited[next] = true;
                    count++;
                }
            }
        }

        if (count == list.size()) {
            return true;
        } else {
            return false;
        }
    }

    public static void getDiff() {
        int a = 0, b = 0;
        for (int i = 0; i < N; i++) {
            if (selected[i]) {
                a += person[i];
            } else {
                b += person[i];
            }
        }
        result = Math.min(result, Math.abs(b - a));
    }
}