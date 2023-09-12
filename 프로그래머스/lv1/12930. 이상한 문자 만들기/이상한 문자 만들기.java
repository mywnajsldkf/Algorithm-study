class Solution {
    public String solution(String s) {
        String answer = "";        
        String[] words = s.split("");
        int idx = 0;
        
        for(String word : words) {
            if(word.equals(" ")) {
                idx = 0;
                answer += " ";
            } else {
                answer += idx % 2 == 0 ? word.toUpperCase() : word.toLowerCase();
                idx++;
            }
        }
        
        return answer;
    }
}