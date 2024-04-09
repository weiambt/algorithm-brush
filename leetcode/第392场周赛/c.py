class Solution:
    def minOperationsToMakeMedianK(self, nums: List[int], k: int) -> int:
        n = len(nums)
        nums.sort()
        mid = n//2
        ans = 0
        if nums[mid]!=k:
            ans += abs(k-nums[mid])
            nums[mid] = k
        for i in range(mid-1,-1,-1):
            if nums[i]<=nums[i+1]:
                break
            ans += abs(nums[i+1]-nums[i])
            nums[i] = nums[i+1]
        
        for i in range(mid+1,n):
            if nums[i-1]<=nums[i]:
                break
            ans += abs(nums[i-1]-nums[i])
            nums[i] = nums[i-1]
        return ans