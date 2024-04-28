class Solution:
    def numberOfRightTriangles(self, grid: List[List[int]]) -> int:
        n,m = len(grid),len(grid[0])
        ans = 0
        row = [0 for _ in range(n)]
        col = [0 for _ in range(m)]
        for i in range(n):
            for j in range(m):
                if grid[i][j]==1: 
                    row[i] += 1
                    col[j] += 1
        for i in range(n):
            for j in range(m):
                if grid[i][j]==1:
                    ans += (row[i]-1)*(col[j]-1)
                    
        return ans