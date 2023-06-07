import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static String paper;
    static List<BigInteger> result;
    static Object[] resultArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        result = new ArrayList<>();
        String number = "";
        for (int i = 0; i < N; i++) {
            paper = br.readLine();

            for (int j = 0; j < paper.length(); j++) {
                // 숫자이면
                if (isInteger(String.valueOf(paper.charAt(j)))) {
                    number += paper.charAt(j);
                } else {
                    if (number.length() > 0) {
                        int start = 0;
                        for (int s = 0; s < number.length(); s++) {
                            if (number.charAt(s) == '0') {
                                continue;
                            } else {
                                start = s;
                                break;
                            }
                        }
                        number = number.substring(start);
                        result.add(new BigInteger((number)));
                        number = "";
                    }
                }
            }

            if (number.length() > 0) {
                result.add(new BigInteger((number)));
                number = "";
            }
        }

        resultArr = result.toArray();
        Arrays.sort(resultArr);

        for (int i = 0; i < resultArr.length; i++) {
            sb.append(resultArr[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
