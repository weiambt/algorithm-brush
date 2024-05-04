class Solution:
    def minimumAddedInteger(self, nums1: List[int], nums2: List[int]) -> int:
        mxn = len(nums1)
        n = len(nums2)
        nums1.sort()
        nums2.sort()
        selected = [-1,-1]
        ans = inf
        
        def dfs(u,st):
            if u==2:
                k = 0
                flag = 1
                lastcha = -inf
                for i in range(mxn):
                    if i not in selected:
                        cha = nums2[k]-nums1[i]
                        # print(cha)
                        if k!=0 and cha != lastcha:
                            flag = 0
                            break
                        k += 1
                        lastcha = cha
                if flag==1:
                    nonlocal ans
                    ans = min(ans,lastcha)
                return
            
            for i in range(st,mxn):
                selected[u] = i
                if dfs(u+1,i+1):
                    return True
            return False
                
        
        dfs(0,0)
        return ans