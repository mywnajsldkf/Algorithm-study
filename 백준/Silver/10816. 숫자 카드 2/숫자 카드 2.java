import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(numbers);
        
        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            bw.write(upperBound(target) - lowerBound(target)+" ");
        }
        bw.flush();
        bw.close();
    }

    private static int upperBound(int target) {
        int first = 0;
        int last = numbers.size();
        while (first < last) {
            int middle = (first + last) / 2;
            if (numbers.get(middle) <= target) {
                first = middle + 1;
            } else last = middle;
        }
        return last;
    }

    private static int lowerBound(int target) {
        int first = 0;
        int last = numbers.size();
        while (first < last) {
            int middle = (first + last) / 2;
            if (numbers.get(middle) < target) {
                first = middle + 1;
            }
            else
                last = middle;
        }
        return last;
    }
}