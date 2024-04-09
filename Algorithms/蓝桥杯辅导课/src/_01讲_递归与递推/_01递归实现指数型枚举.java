package _01讲_递归与递推;
//92. 递归实现指数型枚举
import java.util.*;
public class _01递归实现指数型枚举 {
	static int n;
	static int[] st = new int[22];

	static void dfs(int pos) {
		if(n<pos) {
			for(int i=1;i<=n;i++)
				if(st[i]==1)
					System.out.print(i+" ");
			System.out.println();
			return;
		}

		//选择第pos个
		st[pos] = 1;
		dfs(pos+1);
		
		//不选第pos个
		st[pos] = 2;
		dfs(pos+1);
		st[pos] = 0;

	}
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dfs(1);
	}
}
