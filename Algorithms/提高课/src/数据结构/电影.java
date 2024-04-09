package 数据结构;


import java.util.*;
public class 电影 {
	static int N =201000;
	static int[] a = new int[N],b = new int[N],c = new int[N],t = new int[3*N];
	static Integer[] order = new Integer[3*N];
	static int[] cnt = new int[3*N];
	static int n,m,idx;

	static int find(int x){
	    int l = 0,r = idx-1;
	    while(l<r){
	        int mid = l+r+1>>1;
	        if(order[mid]<=x) l = mid;
	        else r = mid-1;
	    }
	    return l;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1;i<=n;i++) {
		    a[i] = sc.nextInt();
		    t[++idx] = a[i];
		}
		m = sc.nextInt();
		for(int i=1;i<=m;i++) {
		    b[i] = sc.nextInt();
		    t[++idx] = b[i];
		}
		for(int i=1;i<=m;i++) {
		    c[i] = sc.nextInt();
		    t[++idx] = c[i];
		}
		
		HashSet<Integer> se = new HashSet<Integer>();
		for(int i=1;i<=idx;i++)
			se.add(t[i]);
		idx = se.size();
		order = se.toArray(new Integer[0]);
		for(int i=1;i<=n;i++) {
		    int x = find(a[i]);
		  //  System.out.print(x+" ");
		    cnt[x]++;
		}
			
// 		for(int i=1;i<=m;i++) 
// 		    System.out.println(b[i]);
		int ans1=0,ans2=0,ans=1;
		for(int i=1;i<=m;i++) {
			int x = find(b[i]);
			int y = find(c[i]);
			int bb = cnt[x];
			int cc = cnt[y];
			if(bb>ans1 || (bb==ans1 && cc>ans2)) {
				ans1 = bb;
				ans2 = cc;
				ans = i;
			}
		}
		System.out.println(ans);
	}
}
