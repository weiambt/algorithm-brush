class Solution:
    def getSmallestString(self, s: str, k: int) -> str:
        alphabet = 'abcdefghijklmnopqrstuvwxyz'
        n = len(s)
        s = list(s)

        def distance(s1, s2):
            dist = 0
            for i in range(len(s1)):
                dist += min(abs(alphabet.index(s1[i]) - alphabet.index(s2[i])),
                            26 - abs(alphabet.index(s1[i]) - alphabet.index(s2[i])))
            return dist

        for i in range(n):
            for c in alphabet:
                s_copy = s.copy()
                s_copy[i] = c
                if distance(s, s_copy) <= k:
                    k -= distance(s, s_copy)
                    s = s_copy
                    
                    break
        return ''.join(s)
            