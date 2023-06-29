import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static Map<String, Integer> person;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        person = new HashMap<>();

        // 듣도 못한 사람의 명단
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            person.put(name, 1);
        }

        // 보도 못한 사람의 명단
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (person.containsKey(name)) {
                person.put(name, person.get(name) + 1);
            }
        }

        Set set = person.entrySet();
        Iterator iterator = set.iterator();

        int count = 0;
        List<String> result = new ArrayList<>();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iterator.next();
            if (entry.getValue() == 2) {
                count++;
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);

        sb.append(count).append("\n");

        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
