package _202211.acwing;
/**
 * 2454. 下一个更大元素 IV
 * 
 * 做不出来
 * @author ZW
 *
 */
import java.util.*;
class Solution {
	static int N = 101000;
	static int[] stk = new int[N];
	static int[] firstIdx = new int[N];
	static int[] ans = new int[N];
	static int top;
	
	public static void main(String[] ss) {
		int[] arr = {2,4,0,9,6};
		secondGreaterElement(arr);
	}
	
    public static int[] secondGreaterElement(int[] arr) {
    	int n = arr.length;
    	for(int i=n-1;n>=0;n--) {
    		while(top!=0 && arr[stk[top]] <= arr[i])
    			top--;
    		if(top!=0)
    			firstIdx[i] = stk[top];
    		else firstIdx[i] = -1;
    		stk[++top] = i;
    		
    	}
    	System.out.println(Arrays.toString(firstIdx));
    	for(int i=n-1;n>=0;n--) {
    		
    		if(firstIdx[i]!=-1) {
    			
    		}else {
    			ans[i]=-1;
    		}
    	}
    	return null;

    }
}
