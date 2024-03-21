class FrequencyTracker:
    # 1510分
    # 双哈希表
    # mp统计元素出现次数
    # fremp统计出现次数的出现次数

    def __init__(self):
        self.mp = Counter()
        self.fremp = Counter()

    def add(self, number: int) -> None:
        self.fremp[self.mp[number]] -= 1
        self.mp[number] += 1
        self.fremp[self.mp[number]] += 1

    def deleteOne(self, number: int) -> None:
        if self.mp[number]>0:
            self.fremp[self.mp[number]] -= 1
            self.mp[number] -= 1
            self.fremp[self.mp[number]] += 1
            
    def hasFrequency(self, frequency: int) -> bool:
        return self.fremp[frequency]!=0



# Your FrequencyTracker object will be instantiated and called as such:
# obj = FrequencyTracker()
# obj.add(number)
# obj.deleteOne(number)
# param_3 = obj.hasFrequency(frequency)