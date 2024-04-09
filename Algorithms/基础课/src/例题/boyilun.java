package 例题;

import java.util.*;
import java.math.*;
import java.io.*;

public class boyilun {
		static int INF = 1000000007;
		static int N = 101000 , M = 2*N;
		static PII[] arr = new PII[N];
		static int n,m,ans;
		
		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			for(int i=1;i<=n;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr[i] = new PII(a,b);
			}
			Arrays.sort(arr,1,n+1,(a,b)->(a.l-b.l));
			//使用小根堆维护所有组的右端点的最小值
			//在已经存在的组中，没有右端点比当前区间的左端点小的，那么就新开一个组
			//					    有右端点比当前区间的左端点小的，那么就加到这个组中
			//用堆的原因：只需要判断所有组中是否存在一个组的右端点比它小，所以直接维护右端点的最小值即可
			PriorityQueue<Integer> q = new PriorityQueue<Integer>((a,b)->(a-b));
			for(int i=1;i<=n;i++) {
				PII now = arr[i];
				//当前所有组的右端点最小值比左端点大，那么就新建组
				if(q.size()==0 || q.peek()>=now.l) {
					q.add(now.r);
					ans++;
				}else {//否则就加入到右端点最小的组中（这里其实加到哪一组都是一样的，为了方便加入到最小的组中）
					q.poll();
					q.add(now.r);
				}
			}
			System.out.println(ans);
		}
		
}
class PII{
	int l,r;
	public PII(int l,int r) {
		// TODO Auto-generated constructor stub
		this.l = l;
		this.r = r;
	}
}
