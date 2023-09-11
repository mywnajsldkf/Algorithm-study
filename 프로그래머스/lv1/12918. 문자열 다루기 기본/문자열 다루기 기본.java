class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if(s.length() != 4 && s.length() != 6) {
            answer = false;
        } else {
            for(int i = 0; i < s.length(); i++) {
                // System.out.println(s.charAt(i));
                if((int) s.charAt(i) >= 65) {
                    answer = false;
                    break;
                }
            }
        }
        
        return answer;
    }
}