package _202302.acwing._101;
import java.util.*;

public class A {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static int[] arr = new int[N];
	static int n,m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		double ans1 = (-b+Math.sqrt(b*b-4*a*c))/(2*a);
		double ans2 = (-b-Math.sqrt(b*b-4*a*c))/(2*a);
		if(ans2>ans1) {
			double t = ans1;
			ans1=ans2;
			ans2=t;
		}
		System.out.printf("%.6f\n",ans1);
		System.out.printf("%.6f",ans2);
	}
}
