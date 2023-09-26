import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> grade = new HashMap<>();
        for(int i = 0; i < name.length; i++) {
            grade.put(name[i], yearning[i]);
        }
        
        int idx = 0;
        for(String[] people : photo) {
            int sum = 0;
            for(String p : people) {
                // System.out.println(answer[idx]);
                // System.out.println("p: " + p);
                // answer[idx] = answer[idx] + grade.get(p);
                sum += grade.getOrDefault(p, 0);
            }
            answer[idx] = sum;
            idx++;
        }
        return answer;
    }
}