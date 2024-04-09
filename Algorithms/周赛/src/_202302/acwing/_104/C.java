package _202302.acwing._104;
import java.util.*;

public class C {
	static int INF = 0x3f3f3f3f;
	static int N = 201000,M = 2*N;
	static int[] arr = new int[N],mx = new int[N],ans = new int[N];

	static int n,k;
	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		n = sc.nextInt();

		
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=n;i>1;i--) {
			mx[i] = Math.max(mx[i+1],arr[i]);
			ans[i-1] = mx[i]+1 - arr[i-1];
		}
		for(int i=1;i<=n;i++)
			System.out.print(ans[i]+" ");
		
	}
}
