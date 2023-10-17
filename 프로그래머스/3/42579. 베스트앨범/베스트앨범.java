import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Map<Integer, Integer>> map = new HashMap<>();
        Map<String, Integer> genre = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            Map<Integer, Integer> getMap = map.getOrDefault(genres[i], new HashMap<>());
            getMap.put(i, plays[i]);
            map.put(genres[i], getMap);
            
            genre.put(genres[i], genre.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> keySet = new ArrayList<>(genre.keySet());
        
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return genre.get(o2) - genre.get(o1);
            }
        });
        
        for(String key : keySet) {
            Map<Integer, Integer> musics = map.get(key);
            List<Integer> musicKey = new ArrayList<>(musics.keySet());
            musicKey.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return musics.get(o2) - musics.get(o1);
                }
            });
            
            if(musicKey.size() == 1) {
                answer.add(musicKey.get(0));
            }
            else {
                for(int i = 0; i < 2; i++) {
                    answer.add(musicKey.get(i));
                }
            }
        }
        
        return answer;
    }
}