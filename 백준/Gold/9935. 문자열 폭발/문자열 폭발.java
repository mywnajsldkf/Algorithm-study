import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Main {
    static String origin;
    static String bomb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        origin = br.readLine();
        bomb = br.readLine();
        
        int oriLen = origin.length();
        int bombLen = bomb.length();
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < oriLen; i++) {
            char c = origin.charAt(i);
            st.add(c);
            if(st.size() >= bombLen) {
                // 폭발 문자열과 서브 문자열이 같은지 검사
                boolean isSame = true;
                for(int idx = 0; idx < bombLen; idx++) {
                    char c1 = st.get(st.size() - bombLen + idx);
                    char c2 = bomb.charAt(idx);
                    if(c1 != c2) {
                        isSame = false;
                        break;
                    }
                }
                if(isSame) {
                    for(int cnt = 0; cnt < bombLen; cnt++) {                        
                        st.pop();
                    }
                }
            }
        }
        if(st.size() == 0) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for(char c : st) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}