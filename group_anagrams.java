import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Generate a hash String ArrayList
        //Traverse list  sort the word and place it in the corresponding key
        //O(n*k) n is the amount of items k is the max length of the strings that need to be sorted
        //https://leetcode.com/problems/group-anagrams/
        
        int len = strs.length;
        Hashtable<String, List<String>> anagrams = new Hashtable<>();
        
        for(int i=0; i<len; i++){
            char[] sorted = strs[i].toCharArray(); 
            Arrays.sort(sorted);
            String key = String.valueOf(sorted);
            List<String> temp = new ArrayList<>();
             
            if(anagrams.containsKey(key)){
                temp = anagrams.get(key);
                
            }
            temp.add(strs[i]);
            anagrams.put(key, temp);
        }
        
        
        List<List<String>> answer = new ArrayList<>();
        
        for(List<String> item: anagrams.values() ){
            answer.add(item);
        }
        
        return answer;
        
    }
}
