import java.util.*;

class Solution {
    static int answer;
    static String[] keys;
    static boolean[] visited;
    static Map<String, Integer> map;
    public int solution(String[][] clothes) {
        map = new HashMap<>();
        answer = 1;
        
        for(String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }
        
        // keySet을 만든다.
        keys = new String[map.size()];
//         
        int idx = 0;
        for(String key : map.keySet()) {
            // System.out.println("map.keySet(): " + key);
            // keys[idx] = key;
            answer *= (map.get(key)  +1 );
         }
        
//         for(int c = 1; c <= map.size(); c++) {  // 몇개 선택할 것인지 고르고
//             visited = new boolean[map.size()];
//             dfs(c, 0);
            
//         }
        
                
        return answer - 1;
    }
    
//     static void dfs(int size, int depth) {
//         if(size == depth) {
//             int s = 1;
            
//             for(int v = 0; v < visited.length; v++) {
//                 if(visited[v]) {
//                     System.out.println(keys[v]);
//                     // s *= map.get(keys[v]);
//                 }
//             }            
//             answer += s;
//             System.out.println("answer: " + answer);
//         }
        
//         for(int now = 0; now < visited.length; now++) {
//             if(visited[now]) {
//                 continue;
//             }
//             visited[now] = true;
//             dfs(size, depth+1);
//             visited[now] = false;
//         }
//     }
}