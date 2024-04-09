package _202302.acwing._104;
import java.util.*;

public class A {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static int[] arr = new int[N];
	static int n,a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = sc.nextInt();
		if(a%2==0) {
			System.out.println(n/2-a/2+1);
		}else {
			System.out.println(a/2+1);
		}
	}
}
