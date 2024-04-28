class Solution:
    def canMakeSquare(self, g: List[List[str]]) -> bool:
        n = 3
        for i in range(n-1):
            for j in range(n-1):
                cnt = 0
                if g[i+1][j]==g[i][j]:
                    cnt += 1
                if g[i][j+1]==g[i][j]:
                    cnt += 1
                if g[i+1][j+1]==g[i][j]:
                    cnt += 1
                if cnt>=2:
                    return True
                cnt = 0
                if g[i+1][j]!=g[i][j]:
                    cnt += 1
                if g[i][j+1]!=g[i][j]:
                    cnt += 1
                if g[i+1][j+1]!=g[i][j]:
                    cnt += 1
                if cnt>=3:
                    return True
        return False