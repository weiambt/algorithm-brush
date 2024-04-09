package _202302.acwing._101;
import java.util.*;

public class C {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static int[] arr = new int[N];

	static int ans,n;
	static void solve() {
		TreeMap<Integer,Integer> mp = new TreeMap<>();
		
		for(int i=1,j=1;i<=n;i++) {
			
			mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);

			while(mp.lastKey()-mp.firstKey()>1) {
				mp.put(arr[j],mp.get(arr[j])-1);
				if(mp.get(arr[j])==0)
					mp.remove(arr[j]);
				j++;
			}
			ans = Math.max(ans,i-j+1);
		}
	}

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		n = sc.nextInt();

		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		
		solve();
		System.out.println(ans);
		
	}
}
