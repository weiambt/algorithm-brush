class Solution:
    def maximumPrimeDifference(self, nums: List[int]) -> int:
        def check(x):
            if x<2:return False
            for i in range(2,x):
                if x%i==0:
                    return False
            return True
        n = len(nums)
        i = 0
        while i<n:
            if check(nums[i]):
                break
            i +=1
        j = n-1
        while j>=0:
            if check(nums[j]):
                break
            j -= 1
        return j-i