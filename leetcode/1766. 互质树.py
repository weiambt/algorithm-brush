coprimes = [[] for _ in range(51)]
for i in range(1,51):
    for j in range(1,51):
        if gcd(i,j)==1:
            coprimes[i].append(j)

class Solution:
    def getCoprimes(self, nums: List[int], edges: List[List[int]]) -> List[int]:
        n = len(nums)
        e = [[] for _ in range(n)]
        ans = [-1]*n
        for a,b in edges:
            e[a].append(b)
            e[b].append(a)
        val_depth_id = [(-1,-1) for _ in range(51)]
        def dfs(u,fa,dep):
            
            mx_dep = -1
            mx_id = -1
            for x in coprimes[nums[u]]:
                depth,idd = val_depth_id[x]
                if depth > mx_dep:
                    mx_dep = depth
                    mx_id = idd
            ans[u] = mx_id
            tmp = val_depth_id[nums[u]]
            val_depth_id[nums[u]] = (dep,u)
            for j in e[u]:
                if j!=fa:
                    dfs(j,u,dep+1)
            val_depth_id[nums[u]] = tmp
                    
        dfs(0,-1,0)
        return ans
                