package _02讲_二分和前缀和;
import java.util.*;
import java.math.*;

public class _07分巧克力 {

	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int n,k;
	static int[][] arr = new int[N][2];
	static int check(int a) {
		int cnt=0;
		for(int i=1;i<=n;i++) {
			int h = arr[i][0];
			int w = arr[i][1];
			if(h<a || w<a) continue;
			cnt += h/a * (w/a);
			if(cnt>=k) return 1;
		}
		return 0;
	}
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		int right=INF;
		for(int i=1;i<=n;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			right = Math.max(right, Math.max(arr[i][0], arr[i][1]));
		}
		
		int l = 1,r = right;
		while(l<r) {
			int mid = (l+r+1)>>1;
			if(check(mid)==1) l = mid;
			else r = mid-1;
		}
		System.out.println(l);
	}

}
