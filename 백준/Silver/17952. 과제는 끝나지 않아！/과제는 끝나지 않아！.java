import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int isWork;
    static List<int[]> works;

    static int workIndex;
    static int result = 0;
    static int now_grade = 0;
    static int new_time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 몇 분

        works = new ArrayList<>();
        workIndex = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            isWork = Integer.parseInt(st.nextToken());
//            System.out.println("isWork = " + isWork);
            // 과제인 경우
            if (isWork == 1) {
                int grade = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
//                System.out.println("grade = " + grade);
//                System.out.println("time = " + time);
                works.add(new int[]{grade, time});
                workIndex++;
//                System.out.println("workIndex1 = " + workIndex);
            } else if (isWork == 0){
//                System.out.println("workIndex2 = " + workIndex);
                // 해당 지점에 과제가 주어지지 않았다면 그냥 넘어간다.

            }

            if (workIndex < 0) {
                continue;
            }

            now_grade = works.get(workIndex)[0];
            new_time = works.get(workIndex)[1] - 1;
//            System.out.println("now_grade = " + now_grade);
//            System.out.println("new_time = " + new_time);
            works.set(workIndex, new int[]{now_grade, new_time});

            if (new_time == 0) {
                result += now_grade;
                works.remove(workIndex);
                workIndex -= 1;
            }
        }

        sb.append(result);
        System.out.println(sb);
    }
}