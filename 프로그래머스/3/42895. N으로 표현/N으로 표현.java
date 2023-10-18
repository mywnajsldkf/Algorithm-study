import java.util.*;

class Solution {
    static int[] dp;
    public int solution(int N, int number) {
        int answer = -1;
        
        if(N == number) {
            return 1;
        }
        
        List<HashSet<Integer>> numbers = new ArrayList<>();
        
        for(int i = 0; i <= 8; i++) {
            numbers.add(new HashSet<>());
        }
        
        numbers.get(1).add(N);
        
        for(int i = 2; i <= 8; i++) {
            HashSet<Integer> current = numbers.get(i);
            StringBuilder sb = new StringBuilder().append(N);
            for(int j = 1; j < i; j++) {
                sb.append(N);
            }
            
            current.add(Integer.parseInt(sb.toString()));
            for(int j = 1; j < i; j++) {
                HashSet<Integer> first = numbers.get(j);
                HashSet<Integer> second = numbers.get(i-j);
                
                for(int n1 : first) {
                    for(int n2 : second) {
                        current.add(n1 + n2);
                        current.add(n1 - n2);
                        current.add(n1 * n2);
                        if(n2 != 0) {
                            current.add(n1 / n2);
                        }
                    }
                }
            }
            
            if(current.contains(number)) {
                return i;
            }
            
        }

        return answer;
    }
}