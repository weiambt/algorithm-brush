class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        n = len(nums)
        for sz in range(n,-1,-1):
            # i+sz-1<n
            for i in range(n+1-sz):
                order = 0
                flag = 1
                for j in range(i+1,i+sz):
                    if nums[j]>nums[j-1]:
                        if order==-1:
                            flag = 0
                            break
                        order = 1
                    elif nums[j]<nums[j-1]:
                        if order==1:
                            flag = 0
                            break
                        order = -1
                    else:
                        flag = 0
                        break
                if flag:
                    return sz
        return 0