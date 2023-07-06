import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] word = sc.next().toCharArray();
        long sum = 0, tmp = 0;

        for (int i = 0; i < N; i++) {
            if (word[i] >= '0' && word[i] <= '9') {
                tmp = tmp * 10 + word[i] - '0';
            } else {
                sum += tmp;
                tmp = 0;
            }
        }

        sum += tmp;
        System.out.println(sum);
    }
}