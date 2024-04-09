package _01搜索;
import java.util.*;


public class 递归实现排列型枚举 {
	static int N = 30;
	static int n;
	static int[] st = new int[N],ans = new int[N];
	static void dfs(int u) {
		if(u>n) {
			
			for(int i=1;i<=n;i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			
			return ;
		}
		for(int i=1;i<=n;i++) {
			if(st[i]==0) {
				st[i]=1;
				ans[u]=i;
				dfs(u+1);
				st[i]=0;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		dfs(1);
	}
}
