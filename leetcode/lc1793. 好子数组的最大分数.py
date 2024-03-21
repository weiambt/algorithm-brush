class Solution:
    def maximumScore(self, nums: List[int], k: int) -> int:
        n = len(nums)
        # 单调栈，找到i左边/右边离他最近的比它小的数
        l = [-1]*n
        r = [n]*n
        stk = []
        for i in range(n):
            while len(stk) and nums[stk[-1]] >= nums[i]:
                stk.pop()
            l[i] = stk[-1] if len(stk) else -1
            stk.append(i)
        stk = []
        for i in range(n-1,-1,-1):
            while len(stk) and nums[stk[-1]] >= nums[i]:
                stk.pop()
            r[i] = stk[-1] if len(stk) else n
            stk.append(i)
        ans = 0
        for i in range(n):
            if l[i]<k and r[i]>k:
                res = (r[i]-l[i]-1)*nums[i]
                ans = max(ans,res)
        return ans