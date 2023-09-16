import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        List<String> stringList = new ArrayList<>();
        
        for(String str : strings) {
            stringList.add(str);
        }

        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.charAt(n) == s2.charAt(n)) {
                    return s1.compareTo(s2);
                }
                else if(s1.charAt(n) > s2.charAt(n)) {
                    return 1;
                } 
                else {
                    return -1;
                }
            }
        });
            
        for(int i = 0; i < stringList.size(); i++) {
            // System.out.println(stringList.get(i));
            answer[i] = stringList.get(i);
        }
        
        return answer;
    }
}