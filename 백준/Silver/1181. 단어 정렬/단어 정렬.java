import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static String[] word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 단어의 개수

        word = new String[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            word[i] = st.nextToken();
        }

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(word));
        String[] nonDupArray = linkedHashSet.toArray(new String[]{});

        for (int i = 0; i < nonDupArray.length; i++) {
            for (int j = i + 1; j < nonDupArray.length; j++) {
                if (nonDupArray[i].length() == nonDupArray[j].length()) {
                    if (nonDupArray[i].compareTo(nonDupArray[j]) > 0) {
                        String tmp = nonDupArray[i];
                        nonDupArray[i] = nonDupArray[j];
                        nonDupArray[j] = tmp;
                    }
                }
                else if (nonDupArray[i].length() > nonDupArray[j].length()) {
                    String tmp = nonDupArray[i];
                    nonDupArray[i] = nonDupArray[j];
                    nonDupArray[j] = tmp;
                }
            }
        }

        for (int i = 0; i < nonDupArray.length-1; i++) {
            System.out.println(nonDupArray[i]);
        }
        System.out.println(nonDupArray[nonDupArray.length -1]);
    }
}