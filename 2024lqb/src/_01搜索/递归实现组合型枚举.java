package _01搜索;
import java.util.*;


public class 递归实现组合型枚举 {
	static int N = 30;
	static int n,m;
	static int[] ans = new int[N];
	static void dfs(int u,int start) {
		if(u>m) {
			
			for(int i=1;i<=m;i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			
			return ;
		}
		for(int i=start;i<=n;i++) {
			ans[u] = i;
			dfs(u+1,i+1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		dfs(1,1);
	}
}
