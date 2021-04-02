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


class Solution:
	def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:

		pointer1 = list1
		pointer2 = list1
		while pointer1.next and pointer1.val != a:
			if pointer1.val == a:
				pointer1.next = list2
				while list2.next:
					list2 =list2.next
			else:
				pointer1 = pointer1.next
				pointer2 = pointer2.next

		while pointer2.next and pointer2.val != b:
			if pointer2.val == b:
				list2.next = pointer2.next
			else:
				pointer2 = pointer2.next

		pointer2.printVals()
		return list1

sol = Solution()
list1 = ListNode(0, ListNode(1, ListNode(2, ListNode(3, ListNode(4,ListNode(5,None))))))
a = 3
b = 4
list2 = ListNode(1000000,ListNode(1000001,ListNode(1000002,None)))
sol.mergeInBetween(list1,a,b,list2)