package _202302.acwing._103;
import java.util.*;

public class C {
	static int INF = 0x3f3f3f3f;
	static int N = 201000,M = 2*N;
	static int[] arr = new int[N];

	static int ans,n,k;
	static int lowerBound(Integer[] q,int l,int r,int x) {
		int mid = (l+r)>>1;
		while(l<r){
			if(q[mid]>=x) r = mid;
			else l = mid+1;
		}
		return q[l]==x?l:0;
	}
	
	static int upperBound(Integer[] q,int l,int r,int x) {
		int mid = (l+r+1)>>1;
		while(l<r){
			if(q[mid]<=x) l = mid;
			else r = mid-1;
		}
		return q[l]==x?l:0;
	}

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		for(int i=1;i<=n;i++) 
			arr[i] = sc.nextInt();
		HashMap<Integer,Integer> mp = new HashMap<Integer, Integer>();
		PriorityQueue<Integer>[] last = new PriorityQueue[N];
		PriorityQueue<Integer> tmp = new PriorityQueue<Integer>((a,b)->a-b);
		for(int i=n;i>0;i--) {
			tmp.add(arr[i]);
			
			System.out.println(tmp.toString());
			last[i] = tmp;
		}
		
		for(int i=1;i<=n;i++) {
			if(arr[i]%k==0) {
				if(arr[i]*k>1e9) continue;
				Integer[] a = {};
				if(i+1<=n)
					a = last[i+1].toArray(new Integer[] {});
				System.out.println(Arrays.toString(a));
				int cnt = upperBound(a, 0, a.length-1, arr[i]*k)-lowerBound(a, 0, a.length-1, arr[i]*k);
				
				ans += mp.get(arr[i]/k) * cnt;
			}
			mp.put(arr[i],mp.getOrDefault(arr[i], 0)+1);
		}
		System.out.println(ans);
		
	}
}
