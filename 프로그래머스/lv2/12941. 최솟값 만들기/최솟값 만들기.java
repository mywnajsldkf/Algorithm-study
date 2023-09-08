import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        Integer[] newA = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Integer[] newB = Arrays.stream(B).boxed().toArray(Integer[]::new);
        
        Arrays.sort(newA);
        Arrays.sort(newB);
        
        for(int i = 0; i < newA.length; i++) {
            answer += newA[i] * newB[newA.length-1-i];
        }
        
        return answer;
    }
}