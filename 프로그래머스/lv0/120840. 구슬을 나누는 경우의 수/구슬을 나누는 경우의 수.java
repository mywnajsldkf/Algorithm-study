import java.math.*;

class Solution {
    public BigInteger solution(int balls, int share) {
        return factorial(balls).divide(factorial(balls-share).multiply(factorial(share)));
    }
    
    public BigInteger factorial(int number) {
        BigInteger result = BigInteger.valueOf(1);
        for(int i = 1; i <= number; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}