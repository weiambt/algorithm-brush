class Solution:
    # 排列组合
    def countSubstrings(self, s: str, c: str) -> int:
        cnt = s.count(c)
        return cnt*(cnt+1)//2