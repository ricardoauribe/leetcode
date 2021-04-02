# merge in between lists
# https://leetcode.com/problems/merge-in-between-linked-lists/

# Definition for singly-linked list.
class ListNode:
	def __init__(self, val=0, next=None):
		self.val = val
		self.next = next

	def printVals(self):
		while self.next:
			print(self.val)
			self = self.next
		print(self.val)


class Solution:
	def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:

		prev = None
		curr = list1
		head = curr

		while curr.next and curr.val != a:
			prev = curr
			curr = curr.next
			
		list1Pointer = prev.next
		prev.next = list2
		curr = list2

		while curr.next:
			prev = curr
			curr = curr.next

		while list1Pointer.next and list1Pointer.val != b:
			list1Pointer = list1Pointer.next
				
		curr.next = list1Pointer.next
		return head

sol = Solution()
list1 = ListNode(0, ListNode(1, ListNode(2, ListNode(3, ListNode(4,ListNode(5,None))))))
a = 3
b = 4
list2 = ListNode(1000000,ListNode(1000001,ListNode(1000002,None)))
sol.mergeInBetween(list1,a,b,list2)