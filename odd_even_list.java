/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        //https://leetcode.com/problems/odd-even-linked-list/solution/
        //keep a counter to know if odd or even
        //traverse all to get size and last item
        //for all even remove them and place them by the end of the list
        //O(n) since we are touching all items
        
        int size = 1;
        int counter  = 1;
        ListNode prev = new ListNode();
        ListNode curr = new ListNode();
        ListNode next = new ListNode();
        ListNode answer = new ListNode();
        ListNode last = head;
        prev = null;
        curr = head;
        answer = curr;
        next = null;
        
        if(head != null){
            while(last.next!=null){
                last = last.next;
                size++;
            } 


            while(curr.next!=null && counter <= size){

                next = curr.next;

                if(counter % 2 == 0 ){
                    prev.next = next;
                    last.next = curr;
                    last = curr;
                    last.next = null;
                    curr = next;
                    counter++;
                }
                counter++;
                prev = curr;
                curr=curr.next;
            }
        }
        
        
        return answer;
        
    }
}
