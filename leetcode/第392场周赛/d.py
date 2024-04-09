class Solution:
    # 并查集维护集合的按位&之和
    def minimumCost(self, n: int, edges: List[List[int]], query: List[List[int]]) -> List[int]:

        fa = [-1]*n
        val = [-1]*n
        for i in range(n):
            fa[i] = i
        def find(a):
            if fa[a]==a:
                return a
            fa[a] = find(fa[a])
            return fa[a]
        def union(a,b):
            aa = find(a)
            bb = find(b)
            if aa!=bb:
                fa[aa]=bb
                val[bb] &= val[aa]
                    
        for a,b,w in edges:
            union(a,b)
            ff = find(a)
            val[ff] &= w

        ans = [-1]*len(query)
        for i in range(len(query)):
            a,b = query[i]
            if a==b:
                ans[i] = 0
                continue
            aa = find(a)
            bb = find(b)
            if aa==bb:
                ans[i] = val[aa]
            else:
                ans[i] = -1
        return ans