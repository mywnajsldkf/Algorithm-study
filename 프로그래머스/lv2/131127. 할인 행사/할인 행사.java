class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int days = discount.length;
        
        for(int start = 0; start < days - 10 + 1; start++) {
            boolean success = true;
            for(int w = 0; w < want.length; w++) {
                String item = want[w];
                int count = 0;
                for(int c = start; c < start + 10; c++) {
                    if(item.equals(discount[c])) {
                        count++;
                    }
                }
                
                if(count < number[w]) {
                    success = false;
                    break;
                }
            }
            
            if(success) {
                answer++;
            }
        }
        
        return answer;
    }
}