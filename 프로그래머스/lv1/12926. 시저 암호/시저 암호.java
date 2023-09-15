class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        char[] alphabets = s.toCharArray();
        
        for(char alpha : alphabets) {
            System.out.println(alpha);
            // i++;
            if(alpha == ' ') {
                answer += alpha;
            } 
            else if(alpha >= 'a' && alpha <= 'z') {
                if(alpha + n > 'z') {
                    answer += (char)(alpha-26+n);
                } else {
                    answer += (char)(alpha+n);
                }
            } 
            else if(alpha >= 'A' && alpha <= 'Z') {
                if(alpha + n > 'Z') {
                    answer += (char)(alpha-26+n);
                } else {
                    answer += (char)(alpha+n);
                }
            }
        }
        
        return answer;
    }
}