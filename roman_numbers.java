import java.util.*;

class Solution {
    public int romanToInt(String s) {
        //Convert to char array
        //Two pointers if the next item is hihger its a rest
        //Keep a counter for the total
        //2 operations sum or add
        //Hashtable with values
        //Single traversal O(n)
        
        char[] letters = s.toCharArray();
        Hashtable<Character, Integer> values= new Hashtable<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
        
        if(letters.length <= 0){
            return 0;
        }
        
        int total = 0;
        int current = values.get(letters[0]);
        int prev = values.get(letters[0]);
        
        for(int i=1; i<letters.length; i++){
            current = values.get(letters[i]);
            if(prev >= current){
                total += prev;
            }
            else{
                total -= prev;
            }
            prev=current;
        }
        
        total += current;
        return total;
        
    }
}
