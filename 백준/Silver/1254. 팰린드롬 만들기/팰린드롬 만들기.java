
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] s;
    static int s_len;
    static int left, right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        s = br.readLine().split("");
        s_len = s.length;
        int n =0;
//        left = 0;
//        right = s_len - 1;

        for (int i = 0; i < s_len; i++) {
            left = i;
            right = s_len - 1;

            if(!isPalindrome(left,right)){
                n++;
            }else{
                break;
            }


        }

        sb.append(s_len+n);
        System.out.println(sb);
    }

    private static boolean isPalindrome(int l, int r) {
        while (l <= r) {
            // 앞-뒤가 같다면
            if (s[l].equals(s[r])) {
                l++;
                r--;
            }
            // 앞 뒤가 다르다면 -> 추가해줘야한다.
            else {
                return false;
            }
        }
        return true;
    }

}
