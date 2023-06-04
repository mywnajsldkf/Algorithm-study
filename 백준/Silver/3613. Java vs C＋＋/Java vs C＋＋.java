import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String sentence;
    static String lower_sentence;
    static String result = "";
    static String[] arr_sentence;
    static String[] arr_lower_sentence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sentence = br.readLine();
        lower_sentence = sentence.toLowerCase();

        arr_sentence = sentence.split("");
        arr_lower_sentence = lower_sentence.split("");

        translateLanguage();

        sb.append(result);
        System.out.println(sb);
    }

    public static void translateLanguage() {
        // 전부 lowercase로 바꾼거랑 sentence가 다르다! -> java일 수 있다.
        if (!sentence.equals(lower_sentence)) {
            // 맨 앞이 대문자면 -> 둘다 아님
            if (sentence.charAt(0) != lower_sentence.charAt(0)) {
                result = "Error!";
                return;
            } else if (sentence.contains("_")) {
                result = "Error!";
                return;
            } else {
                // java를 c++로 바꾼다.
                for (int i = 0; i < arr_sentence.length; i++) {
                    // _추가하고 소문자로 바꾼 것을 추가한다.
                    if (!arr_sentence[i].equals(arr_lower_sentence[i])) {
                        result += "_";
                        result += arr_lower_sentence[i];
                    } else {
                        result += arr_sentence[i];
                    }
                }
            }
        }

        // - 포함하고 있으면 c++일 수 있다.
        else if (sentence.contains("_")) {
            // 대문자가 사이에 있었다면, 둘다 아님
            if (!sentence.equals(lower_sentence)) {
                result = "Error!";
                return;

            } else if (arr_sentence[0].equals("_")) {
                result = "Error!";
                return;

            } else if (arr_sentence[arr_sentence.length - 1].equals("_")) {
                result = "Error!";
                return;

            } else {
                for (int i = 0; i < arr_sentence.length; i++) {
                    if (arr_sentence[i].equals("_")) {
                        if (!arr_sentence[i + 1].equals("_")) {
                            result += arr_sentence[i + 1].toUpperCase();
                            i++;
                        } else {
                            result = "Error!";
                            return;

                        }
                    } else {
                        result += arr_sentence[i];
                    }
                }
            }
        } else {
            result = sentence;
        }
    }
}