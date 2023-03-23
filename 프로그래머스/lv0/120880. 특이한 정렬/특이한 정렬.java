import java.util.*;

class Solution {
    public Object[] solution(int[] numlist, int n) {
        List<Integer> answer = new ArrayList<>();
        Integer new_N = new Integer(n);
        for(int i = 0; i < numlist.length; i++){
            answer.add(numlist[i]);
        }
        
        Collections.sort(answer, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                if(Math.abs(a-new_N) != Math.abs(b-new_N)){
                    return Math.abs(a-new_N) - Math.abs(b-new_N);
                }
                else {
                    return b-a;
                }
            }
        });

        return answer.toArray();
    }
}