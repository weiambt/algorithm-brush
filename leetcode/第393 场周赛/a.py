class Solution:
    def findLatestTime(self, s: str) -> str:
        h,m = s.split(":")
        a = h[0]
        b = h[1]
        c = m[0]
        d = m[1]
        ans = [_ for _ in s]
        if a=='?':
            if b=='?':
                ans[0] = '1'
                ans[1] = '1'
            else:
                if b=='1' or b=='0':
                    ans[0] = '1'
                else:
                    ans[0] = '0'
        else:
            if b=='?':
                if a=='1':
                    ans[1] = '1'
                else:
                    ans[1] = '9'
        if c=='?':
            ans[3]='5'
        if d=='?':
            ans[4]='9'
            
        return ''.join(ans)