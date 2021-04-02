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
			print(list1.val)
			list1 = list1.next
		return list1

sol = Solution()
list1 = ListNode(0, ListNode(1, ListNode(2, ListNode(3, ListNode(4,ListNode(5,None))))))
a = 3
b = 4
list2 = ListNode(1000000,ListNode(1000001,ListNode(1000002,None)))
sol.mergeInBetween(list1,a,b,list2)