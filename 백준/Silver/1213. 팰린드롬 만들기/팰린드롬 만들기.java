import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String name;
    static int[] alphabet;
    static int center = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        name = br.readLine();
        alphabet = new int[27];

        for (int i = 0; i < name.length(); i++) {
//            alphabet[(name.charAt(i) - 64) - 1] += 1;
//            System.out.println("(Integer.valueOf(name.charAt(i)) - 64) = " + (Integer.valueOf(name.charAt(i)) - 64));
            alphabet[Integer.valueOf(name.charAt(i)) - 64] += 1;
        }

//        System.out.println("name.charAt(2)-64 = " + (name.charAt(2)-64));
//        System.out.println("(char)2 = " + (char) (2+64));

        int is_odd = 0;
        for (int i = 1; i < 27; i++) {
            if (alphabet[i] % 2 == 1) {
                is_odd += 1;
            }
        }

        if (name.length() == 1) {
            sb.append(name);
        }
        else if (is_odd > 1) {
            sb.append("I'm Sorry Hansoo");
        } else {
            for (int i = 1; i < 27; i++) {
                while (alphabet[i] >= 2) {
//                    System.out.println("i = " + i);
//                    System.out.println("(char)(alphabet[i] + 1) = " + (char) (i + 64));
                    sb.append((char) (i + 64));
                    alphabet[i] -= 2;
                }
                // 하나가 남는다면 이것이 센터원소이다.
                if (alphabet[i] == 1) {
                    center = i;
                }
            }

            if (center != -1) {
                sb.append((char) (center + 64));
                StringBuilder backSb = new StringBuilder(sb.substring(0, sb.length() - 1));
                sb.append(backSb.reverse());
            } else {
                StringBuilder backSb = new StringBuilder(sb.substring(0, sb.length()));
                sb.append(backSb.reverse());
            }


        }
        System.out.println(sb);
    }
}