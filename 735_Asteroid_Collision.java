import java.util.*;
/*
//https://leetcode.com/problems/asteroid-collision/

We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

*/
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // + --> right
        // - <-- left
        // 2 <= asteroids.length <= 10^4
        // -1000 <= asteroids[i] <= 1000
        // asteroids[i] != 0
        // [-2, -1, 1, 2]
        // 2 pointers, direction
        
        Stack<Integer> collisions = new Stack<Integer>();
        Boolean done = false;
        
        for (int i=0; i<asteroids.length; i++){
            
            done = false;
            int current = asteroids[i];
            
            do{
                
               if(collisions.isEmpty()){
                    collisions.push(current);
                    done = true;
                }
                else{
                    
                    int vs = collisions.peek();
                    
                    if(sign(current) == sign(vs)){
                        collisions.push(current);
                        done = true;
                    }
                    else{
                        if(sign(vs) == -1 && sign(current)==1){
                            //No colission so push
                            collisions.push(current);
                            done = true;
                        }
                        else{
                            if(Math.abs(current) > Math.abs(vs)){
                               collisions.pop();
                            }
                            else if(Math.abs(current) < Math.abs(vs)){
                                done = true;
                            }
                            else{
                                collisions.pop();
                                done = true;
                            }  
                        }
                        
                    }
                }
                
                
            }while(done != true);
        }
        
        Object[] temp = collisions.toArray();
        int[] answer = new int[temp.length];
        
        for(int j=0; j<temp.length; j++){
            answer[j] = (int)temp[j];
        }
        
        return answer;
        
    }
    
    public int sign(int number){
        if(number > 0){
            return 1;
        }
        if(number < 0){
            return -1;
        }
        
        return 0;
    }
}
