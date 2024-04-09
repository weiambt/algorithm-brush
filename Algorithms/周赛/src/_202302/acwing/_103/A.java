package _202302.acwing._103;
import java.util.*;

public class A {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static int n,m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int flag = 0;
			for(int x=0;c-a*x>=0;x++) {
				if((c-a*x)%b==0) {
					System.out.println("Yes");
					flag = 1;
					break;
				}
			}
			if(flag==0)
				System.out.println("No");
		}
	}
}
