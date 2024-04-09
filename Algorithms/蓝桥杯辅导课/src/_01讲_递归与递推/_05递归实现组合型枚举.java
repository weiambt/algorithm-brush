package _01讲_递归与递推;
import java.util.*;
public class _05递归实现组合型枚举 {
	static int INF = 0x3f3f3f3f;
	static int N = 28 , M = 2*N;
	static int[] ans = new int[N],st = new int[N];
	static int n,m;

	static void dfs(int pos,int last) {
		if(pos>m) {
			for(int i=1;i<=m;i++)
				System.out.print(ans[i]+" ");	
			System.out.println();
			return;
		}
		for(int i=last+1;i<=n;i++) {
			if(st[i]==0) {
				st[i] = 1;
				ans[pos] = i;
				dfs(pos+1,i);
				st[i] = 0;
			}
		}

	}
	public static void main(String[] sss) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		dfs(1,0);
		
	}
}

