## lc每日一题

- [2789. 合并后数组中的最大元素](https://leetcode.cn/problems/largest-element-in-an-array-after-merge-operations/)1485

  倒序贪心

  ```
  class Solution:
      def maxArrayValue(self, nums: List[int]) -> int:
          n = len(nums)
          for i in range(n-1,0,-1):
              if nums[i]>=nums[i-1]:
                  nums[i-1] += nums[i]
                  nums[i] = 0
          return max(nums)
  ```

  

- 

