package _202302.acwing._105;
import java.util.*;

public class A {
	static int INF = 0x3f3f3f3f;
	static int N = 1010,M = 2*N;
	static int[] arr = new int[N];
	static int n,m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		int ans = 0;
		for(int i=2;i<n;i++) {
			if(arr[i]>arr[i-1] && arr[i]>arr[i+1])
				ans++;
			else if(arr[i]<arr[i-1] && arr[i]<arr[i+1])
				ans++;
		}
		System.out.println(ans);
	}
}
