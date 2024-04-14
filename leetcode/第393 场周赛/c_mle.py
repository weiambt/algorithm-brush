class Solution:
    def findKthSmallest(self, coins: List[int], k: int) -> int:
        def getlcm(a,b):
            return a*b//gcd(a,b)
        coins.sort()
        n = len(coins)
        lcm = 1
        new_coins = []
        for i in range(n):
            x = coins[i]
            lcm = getlcm(lcm,x)
            flag = 1
            for j in range(i):
                if x % coins[j]==0:
                    flag = 0
            if flag:
                new_coins.append(x)
            # print(lcm)
        # print(lcm)
        n = len(new_coins)
        se = set()
        for j in range(n):
            x = new_coins[j]
            kk = 1
            while kk*x<=lcm:
                se.add(kk*x)
                kk+=1
        val = list(se)
        val.sort()
        # print(val)
        t = len(val)
        
        # if k<t:
        #     return val[k-1]
        # print(t)
        # print(lcm*(k//(t+1)))
        ans = lcm*(k//t) if k%t!=0 else lcm*(k//t-1)
        ans += val[k%t-1]
        return ans
            
            