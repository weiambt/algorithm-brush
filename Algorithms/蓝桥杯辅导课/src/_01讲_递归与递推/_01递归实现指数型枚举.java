package _01��_�ݹ������;
//92. �ݹ�ʵ��ָ����ö��
import java.util.*;
public class _01�ݹ�ʵ��ָ����ö�� {
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

		//ѡ���pos��
		st[pos] = 1;
		dfs(pos+1);
		
		//��ѡ��pos��
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
