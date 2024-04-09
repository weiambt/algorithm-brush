package _202302.acwing_acc2;
import java.util.*;

public class A {
	static int INF = 0x3f3f3f3f;
	static int N = 101000, M = 2*N;

	static int[] h = new int[N],e = new int[M],ne = new int[M],w = new int[M];
	static int n,m,ans;
	static int idx;
	static void init() {
		for(int i=1;i<=n;i++)
			h[i] = -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int i;
		for(i=1;i<101000;i++) {
			if(Math.pow(2, i)<=n && Math.pow(2, i+1)>n) {
				break;
			}
		}
		System.out.println(n - (int)Math.pow(2, i) +1);
			
	}
}
