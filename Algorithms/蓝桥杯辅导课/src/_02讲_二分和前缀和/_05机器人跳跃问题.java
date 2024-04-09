package _02讲_二分和前缀和;
import java.util.*;
import java.math.*;

public class _05机器人跳跃问题 {
		static int INF = 0x3f3f3f3f;
		static int N = 101000 , M = 2*N;

		static int n,m;
		static int[] arr = new int[N];
		static int check(int start) {
			long sum = start;
			for(int i=1;i<=n;i++) {
				if(arr[i]<=sum) sum+=(sum-arr[i]);
				else sum-=(arr[i]-sum);
				if(sum<0) {
					return 0;
				}
			}
			return 1;
		}
		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			int mx = 0;
			for(int i=1;i<=n;i++) {
				arr[i] = sc.nextInt();
				mx = Math.max(mx, arr[i]);
			}

			int l = 0,r = mx;
			while(l<r) {
				int mid = (l+r)>>1;
				if(check(mid) == 1) r = mid;
				else l = mid+1;
			}
			System.out.println(l);
		}

}
