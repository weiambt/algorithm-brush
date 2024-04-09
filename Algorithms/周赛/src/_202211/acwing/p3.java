package _202211.acwing;
import java.util.*;
/**
 * WA 4721. 排队,,,思路不对
 * @author ZW
 *
 */
public class p3 {
	static int N = 100100;
	static int arr[] = new int[N];
	static int ans[] = new int[N];
	
	static int[] stk = new int[N];
	static int top=0;
	
	public static void main(String[] ss) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=n;i>0;i--) {
			if(top!=0 && arr[stk[top]]<arr[i]) {
				int l = 1,r = top;
				while(l<r) {
					int mid = (l+r)/2;
					if(arr[stk[mid]]<arr[i]) r=mid;
					else l=mid+1;
				}
				System.out.println(l);
				ans[i] = stk[l] - i -1;
			}else {//arr[i]最小
				ans[i]=-1;
			}
			if(top==0 || arr[stk[top]] >= arr[i]) 
				stk[++top] = i;
		}
		
		for(int i=1;i<=n;i++)
			System.out.print(ans[i]+" ");
//		System.out.println(Arrays.toString(dp));
	}
}
