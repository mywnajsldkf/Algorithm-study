import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());


        // 테스트 케이스
        T = Integer.parseInt(st.nextToken());

        // 테스트 케이스만큼 반복한다.
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            LinkedList<int[]> docs = new LinkedList<>();   // 큐로 활용할 연결 리스트 -> iterator 안쓰고 2차원 배열로

            // 인쇄기 초기화
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                // j: 초기위치, Integer.parseInt(
                docs.add(new int[]{j, Integer.parseInt(st.nextToken())});   // 초기 위치와 충요도를 함께 저장한다.
            }

            int count = 0;  // 출력 횟수를 저장한다.

            // 한 케이스에 대한 반복문
            while (!docs.isEmpty()) {
                int[] front = docs.poll();  // 가장 앞에 있는 원소를 뽑아온다 -> 어차피 뒤로 보내거나, 아니면 삭제할 것이니까
                boolean isMax = true;   // 가장 큰 원소인지 판단한다.

                // 큐에 남아있는 원소들과 중요도를 비교한다.
                for (int k = 0; k < docs.size(); k++) {
                    // 처음 뽑은 원소보다 후에 뽑은 원소의 중요도가 크면
                    if (front[1] < docs.get(k)[1]) {
                        // 뽑은 원소 및 k 이전의 원소들은 뒤로 보낸다.
                        docs.offer(front);  // 뽑은 원소를 뒤로 보냄
                        for (int l = 0; l < k; l++) {   // k 이전의 원소들을 모두 뒤로 보냄
                            docs.offer(docs.poll());
                        }

                        // front 원소가 가장 큰 원소가 아니므로 false를 하고 탐색을 마친다.
                        isMax = false;
                        break;
                    }
                }

                // Front 원소가 가장 큰 원소가 아니므로 다음 반복문으로 넘어간다.
                if (isMax == false) {
                    continue;
                }

                // front 원소가 가장 큰 원소이므로 해당 원소를 출력한다. -> count++한다.
                count++;
                // 찾고자 하는 문서이면 해당 테스트케이스를 종료한다.
                if (front[0] == M) {
                    break;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}
