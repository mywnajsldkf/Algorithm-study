import java.util.*;

class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        List<Integer> numbers = new ArrayList<>();
        
        for(int i = 0; i < str.length; i++) {
            numbers.add(Integer.parseInt(str[i]));
        }
        
        Collections.sort(numbers);
        
        String answer = "";
        answer += numbers.get(0);
        answer += " ";
        answer += numbers.get(numbers.size()-1);
        
        return answer;
    }
}