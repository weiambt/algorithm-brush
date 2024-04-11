package _00Ä£°å;

import java.util.Scanner;
import java.util.TreeSet;


public class ÄæÐòÊý {
	static int N = 101000;
	static int n,m;
	static long ans;
	static int[] tree = new int[N],arr = new int[N];
	static int lowbit(int x) {
		return x&-x;
	}
	static void add(int idx,int v) {
		for(int i=idx;i<=n;i+=lowbit(i))
			tree[i] += v;
	}
	static int query(int idx) {
		int res = 0;
		for(int i=idx;i>0;i-=lowbit(i)) {
			res += tree[i];
		}
		return res;
	}
	static int query(int l,int r) {
		return query(r)-query(l-1);
	}
//	static void init() {
//		for(int i=1;i<=n;i++)
//			add(i,arr[i]);
//	}
	static Integer[] order;
	static void lisanhua() {
		TreeSet<Integer> se = new TreeSet<>();
		for(int i=1;i<=n;i++)
			se.add(arr[i]);
		order = se.toArray(new Integer[1]);
		
	}
	static int find(int l,int r,int x) {
		while(l<r) {
			int mid = l+r>>1;
			if(order[mid] >= x) r = mid;
			else l = mid+1;
		}
		return l;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1;i<=n;i++)
			arr[i] = sc.nextInt();
		lisanhua();
		for(int i=n;i>0;i--) {
			int v = find(0,order.length,arr[i])+1;
			ans += query(v-1);
			add(v,1);
		}
		System.out.println(ans);
	}
}
