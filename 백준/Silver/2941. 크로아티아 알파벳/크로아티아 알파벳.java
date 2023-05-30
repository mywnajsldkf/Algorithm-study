import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static String sentence;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sentence = br.readLine();

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            count += 1;

            if (ch == 'c') {
                if (i < sentence.length() - 1) {
                    if (sentence.charAt(i + 1) == '=') {
                        i += 1;
                    } else if (sentence.charAt(i + 1) == '-') {
                        i += 1;
                    }
                }
            } else if (ch == 'd') {
                if (i < sentence.length() - 1) {
                    if (sentence.charAt(i + 1) == 'z') {
                        if (i < sentence.length() - 2) {
                            if (sentence.charAt(i + 2) == '=') {    // dz=
                                i += 2;
                            }
                        }
                    } else if (sentence.charAt(i + 1) == '-') {     // d-
                        i += 1;
                    }
                }
            } else if (ch == 'l') {
                if (i < sentence.length() - 1) {
                    if (sentence.charAt(i + 1) == 'j') {    // lj
                        i += 1;
                    }
                }
            } else if (ch == 'n') {
                if (i < sentence.length() - 1) {
                    if (sentence.charAt(i + 1) == 'j') {    // nj
                        i += 1;
                    }
                }
            } else if (ch == 's') {
                if (i < sentence.length() - 1) {
                    if (sentence.charAt(i + 1) == '=') {
                        i += 1;
                    }
                }
            } else if (ch == 'z') {
                if (i < sentence.length() - 1) {
                    if (sentence.charAt(i + 1) == '=') {
                        i += 1;
                    }
                }
            }
        }
        sb.append(count);
        System.out.println(sb);
    }
}