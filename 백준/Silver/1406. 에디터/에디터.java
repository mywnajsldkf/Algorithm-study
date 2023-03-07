import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            leftStack.push(str.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String command = br.readLine();

            switch (command.charAt(0)) {
                case 'L':
                    if (!leftStack.isEmpty())
                        rightStack.push(leftStack.pop());
                    break;
                case 'D':
                    if (!rightStack.isEmpty())
                        leftStack.push(rightStack.pop());
                    break;
                case 'B':
                    if (!leftStack.isEmpty())
                        leftStack.pop();
                    break;
                case 'P':
                    leftStack.push(command.charAt(2));
                    break;
                default:
                    break;
            }
        }

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.isEmpty()) {
            bw.write(rightStack.pop());
        }
        bw.flush();
        bw.close();
    }
}