package _02讲_二分和前缀和;
import java.util.*;
import java.math.*;
public class _01数的范围 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int n,q;
	static int[] arr = new int[N];
	
	static int findLeft(int l,int r,int k) {
		while(l<r) {
			int mid = (l+r)>>1;
			if(arr[mid]>=k) r=mid;
			else l = mid+1;
		}
		return l;
	}
	
	static int findRight(int l,int r,int k) {
		while(l<r) {
			int mid = (l+r+1)>>1;
			if(arr[mid]<=k) l=mid;
			else r = mid-1;
		}
		return l;
	}
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		q = sc.nextInt();
		for(int i=1;i<=n;i++) arr[i] = sc.nextInt();
		while(q-->0) {
			int k = sc.nextInt();
			int l = findLeft(1,n,k);
			if(arr[l]!=k) {
				System.out.println("-1 -1");
			}else {
				int r = findRight(1,n,k);
				l--;r--;
				System.out.println(l+" "+r);
			}
			
		}
	}
}
