class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        boolean[] alphabets = new boolean[26];
        for(int i = 0; i < skip.length(); i++) {
            alphabets[(int) skip.charAt(i) - 97] = true;
        }
        
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            
            int idx = index;
            int next = (int) cur - 97;
            while(idx > 0) {
                next = next + 1;
                if(next > 25) next -= 26;
                if(!alphabets[next]) {
                    idx--;
                }
            }
            
            answer += String.valueOf((char)(next + 97));
        }
        
        return answer;
    }
}