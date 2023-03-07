import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 길이

        ArrayList<Coord> coordList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coordList.add(new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(coordList);

        for (int i = 0; i < N; i++) {
            System.out.println(coordList.get(i));
        }
    }
}

class Coord implements Comparable<Coord>{
    private int x;
    private int y;

    Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Coord o) {
        if (o.y > y) {
            return -1;
        }
        if (o.y == y && o.x > x) {
            return -1;
        }
        return 1;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}