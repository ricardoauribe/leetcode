# merge in between lists
# https://leetcode.com/problems/merge-in-between-linked-lists/

# Definition for singly-linked list.
class ListNode:
     def __init__(self, val=0, next=None):
         self.val = val
         self.next = next


class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        while list1.next and list1.val != a:
            print(a.val)
            list1 = list1.next
        return list1

sol = Solution()
list1 = [0,1,2,3,4,5]
a = 3
b = 4
list2 = [1000000,1000001,1000002]
sol.mergeInBetween(list1,a,b,list2)