# Count matches in a tournament
# https://leetcode.com/problems/count-of-matches-in-tournament/submissions/
# time O(nlogn), space O(nlogn)

class Solution:
    def numberOfMatches(self, n: int) -> int:
        if n <= 1:
            return 0
        else:
            m = n//2
            reminder = n%2
            return m + self.numberOfMatches(m+reminder)
