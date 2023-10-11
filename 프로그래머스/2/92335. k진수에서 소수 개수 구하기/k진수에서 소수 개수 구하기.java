import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuffer number = new StringBuffer();
        
        while(n > 0) {
            number.append(String.valueOf(n % k));
            n /= k;
        }
        
        String translatedNumber = number.reverse().toString();
        
        List<Long> splited = new ArrayList<>();
        
        String num = "";
        // boolean zero = false;
        for(int i = 0; i < translatedNumber.length(); i++) {
            if(translatedNumber.charAt(i) == '0' && num.length() != 0) {
                splited.add(Long.parseLong(num));
                num = "";
                // zero = true;
            }
            else if(translatedNumber.charAt(i) != '0') {
                num += String.valueOf(translatedNumber.charAt(i));
            }
        }
        
        if(num.length() != 0) {
            splited.add(Long.parseLong(num));
        }
                
        for(int i = 0; i < splited.size(); i++) {
            Long intNum = splited.get(i);
            
            if(isPrime(intNum)) {
                answer += 1;
            }
        }

        return answer;
    }
    
    static boolean isPrime(long num) {
        // long smallNum = Math.sqrt(num);
        
        if(num <= 1) {
            return false;
        } else if(num == 2) {
            return true;
        }
        
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
}