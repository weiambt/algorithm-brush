package _202302.acwing._102;
import java.util.*;

public class A {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static int[] arr = new int[N];
	static int n,m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int ans = 0,ans2=0;
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
			ans |=arr[i];
		}
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
			ans2 |=arr[i];
		}
		System.out.println(ans+ans2);
	}
}
