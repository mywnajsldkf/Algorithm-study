import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 몇 번

        ArrayList<Point> pointList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pointList.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(pointList);

        for (int i = 0; i < N; i++) {
            System.out.println(pointList.get(i));
        }
    }
}

class Point implements Comparable<Point>{
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

    @Override
    public int compareTo(Point o) {
        if (o.x == x && o.y > y) {
            return -1;
        }
        if (o.x < x) {
            return 1;
        } else if (o.x > x) {
            return -1;
        }
        return 1;
    }
}