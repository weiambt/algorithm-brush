package _01��_�ݹ������;
import java.util.*;
public class _02�ݹ�ʵ��������ö�� {
	static int n;
	static int[] st = new int[10];
	static int[] ans = new int[10];
	static void dfs(int pos) {
		if(pos>n) {
			for(int i=1;i<=n;i++)
				 System.out.print(ans[i]+" ");
			System.out.println();
			return ;
		}
		for(int i=1;i<=n;i++) {
			if(st[i]==0) {
				st[i] = 1;
				ans[pos] = i;
				dfs(pos+1);
				st[i] = 0;
			}
		}
	}
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
	
		n = sc.nextInt();
		dfs(1);
	}
}
