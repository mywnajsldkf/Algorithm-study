import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static boolean[] visited;
    static int[] arr;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        visited = new boolean[n];
        arr = new int[n];

        nQueen(0);
        sb.append(count);
        System.out.println(sb);
    }

    private static void nQueen(int depth) {
        if (depth == n){
            count += 1;
        }

        for(int i = 0; i < n; i++){
            if(visited[i]){
                continue;
            }
            arr[depth] = i;
            if(togo(depth)){
                visited[i] = true;
                nQueen(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean togo(int depth) {
        for(int i = 0; i < depth; i++){
            if(arr[i] == arr[depth]){
                return false;
            }
            else if (Math.abs(depth-i) == Math.abs(arr[depth]-arr[i])){
                return false;
            }
        }
        return true;
    }
}
