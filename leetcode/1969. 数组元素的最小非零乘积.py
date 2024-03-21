class Solution:
# https://blog.csdn.net/Supreme7/article/details/136876624?spm=1001.2014.3001.5501
# 思维+构造，难度大
    def minNonZeroProduct(self, p: int) -> int:
        mod = 10**9+7
        def qpow(a,b):
            res = 1
            while b>0:
                if (b&1)==1:
                    res = res * a%mod
                a = a * a%mod
                b>>=1
            return res
        kk = 2**p-1
        bb = 2**(p-1)-1
        return kk%mod * qpow((kk-1),bb)%mod