package _202302.acwing._106;
import java.util.*;

public class A {
	static int INF = 0x3f3f3f3f;
	static int N = 1010,M = 2*N;
	static int[] arr = new int[N];
	static int n,m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		char[] s = sc.next().toCharArray();
		
		while(m-->0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			char c1 = sc.next().toCharArray()[0];
			char c2 = sc.next().toCharArray()[0];
			for(int i=l-1;i<=r-1;i++)
				if(s[i]==c1)
					s[i] = c2;
		}
		for(int i=0;i<s.length;i++)
			System.out.print(s[i]);
		
	}
}
