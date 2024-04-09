package _202302.acwing._102;
import java.util.*;

public class C2 {
	static int INF = 0x3f3f3f3f;
	static int N = 201000,M = 2*N;
	static int[] arr = new int[N];

	static int ans,n,k;
	

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		for(int i=1;i<=n;i++) 
			arr[i] = sc.nextInt();
		HashMap<Integer,Integer> mp = new HashMap<Integer, Integer>();
		int[] r = new int[N];
		for(int i=n;i>0;i--) {
			if((long)arr[i]*k<=1e9 && mp.getOrDefault(arr[i]*k, 0)!=0)
				r[i] = mp.get(arr[i]*k);
			mp.put(arr[i],mp.getOrDefault(arr[i], 0)+1);
		}
		mp.clear();
		for(int i=1;i<n;i++) {
			if(arr[i]%k==0) {
				if(arr[i]*k>1e9) continue;
				
				ans += mp.get(arr[i]/k) * r[i];
			}
			mp.put(arr[i],mp.getOrDefault(arr[i], 0)+1);
		}
		System.out.println(ans);
		
	}
}
