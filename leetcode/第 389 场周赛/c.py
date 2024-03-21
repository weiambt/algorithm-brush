class Solution:
    # 思维+哈希表，比赛没做出来
    # 长度是1e5的字符串，变成哈希表后长度最大就是26了（26个英文字母）
    # 思维点：小的值要么全删掉，要么留着；大值减到一个min+k的位置即可
    # 然后就是枚举最小的值作为起点
    # https://leetcode.cn/contest/weekly-contest-389/problems/minimum-deletions-to-make-string-k-special/
    def minimumDeletions(self, word: str, k: int) -> int:
        n = len(word)
        cnt = list(Counter(word).values())
        cnt.sort()
        # print(cnt)
        
        nn = len(cnt)
        ans = n-1

        for i in range(nn):
            s = sum(cnt[:i]) if i else 0
            for j in range(i+1,nn):
                if cnt[j] > cnt[i]+k:
                    s += cnt[j]-(cnt[i]+k)
            ans = min(ans,s)
     
        return ans
            
            