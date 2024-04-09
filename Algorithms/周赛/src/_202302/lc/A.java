package _202302.lc;

class Solution {
    public long findTheArrayConcVal(int[] nums) {
    	int n = nums.length;
    	long ans = 0;
    	for(int i=0;i<n/2;i++) {
    		String a = nums[i]+"";
    		String b = nums[n-i-1]+"";
    		ans += Integer.parseInt(a+b);
    	}
    	if(n%2==1) ans += nums[n/2];
    	return ans;
    }
}