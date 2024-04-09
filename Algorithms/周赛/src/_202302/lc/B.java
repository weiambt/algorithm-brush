class Solution {
	static int[] sum = new int[1010000];
    public int[][] substringXorQueries(String s, int[][] queries) {
    	for(int i=0;i<s.length();i++) {
    		sum[i+1] = sum[i-1]*2+s.charAt(i);
    	}
    	for(int i=0;i<queries.length;i++) {
    		int a = queries[i][0];
    		int b = queries[i][1];
    		int c = a^b;
    		for(int j=1;j<=s.length();j++)
    			
    	}
    }
}