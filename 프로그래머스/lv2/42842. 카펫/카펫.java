class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for(int y = 3; y < sum; y++) {
            int x = sum / y;
            if(sum % y == 0 && x >= 3) {
                int yy = y;
                int yx = x;
                int center = (yy-2)*(yx-2);
                
                if(center == yellow) {
                    int col = Math.max(yy, yx);
                    int row = Math.min(yy, yx);
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}