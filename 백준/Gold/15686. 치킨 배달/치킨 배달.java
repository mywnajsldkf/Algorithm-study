import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static List<Point> chicken;
    static List<Point> house;
    static boolean[] chicken_visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 세로
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        chicken = new ArrayList<>();
        house = new ArrayList<>();

        // 초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    house.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        chicken_visited = new boolean[chicken.size()];

        chicken_delivery(0, 0);
        sb.append(min);
        System.out.println(sb);
    }

    private static void chicken_delivery(int start, int depth) {
        if (depth == M) {
            int value = findDistance();
            min = Math.min(value, min);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            chicken_visited[i] = true;
            chicken_delivery(i + 1, depth + 1);
            chicken_visited[i] = false;
        }
    }

    private static int findDistance() {
        int total_distance = 0;

        for (int i = 0; i < house.size(); i++) {
            total_distance += calculate(house.get(i));
        }
        return total_distance;
    }

    private static int calculate(Point house) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < chicken_visited.length; i++) {
            if (chicken_visited[i] == true) {
                int distance = 0;
                distance += Math.abs(house.x - chicken.get(i).x);
                distance += Math.abs(house.y - chicken.get(i).y);
                min = Math.min(min, distance);
            }
        }
        return min;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}